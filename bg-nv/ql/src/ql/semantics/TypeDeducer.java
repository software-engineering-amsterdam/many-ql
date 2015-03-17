package ql.semantics;

import ql.ast.AstNode;
import ql.ast.expression.*;
import ql.ast.type.*;
import ql.semantics.errors.Error;
import ql.semantics.errors.Messages;

/**
 * Created by bore on 16/03/15.
 */
public class TypeDeducer implements ExprVisitor<Type>
{
    private final static BoolType boolType = new BoolType();
    private final static StrType strType = new StrType();
    private final static IntType intType = new IntType();
    private final static DecType decType = new DecType();
    private final static UndefType undefType = new UndefType();

    private final Questions questions;
    private final Messages messages;

    public static InferredTypeResult deduceType(Expr e, Questions questions)
    {
        TypeDeducer deducer = new TypeDeducer(questions);
        Type type = e.accept(deducer);
        return new InferredTypeResult(type, deducer.messages);
    }

    private TypeDeducer(Questions questions)
    {
        this.questions = questions;
        this.messages = new Messages();
    }

    @Override
    public Type visit(IntExpr n)
    {
        return intType;
    }

    @Override
    public Type visit(BoolExpr n)
    {
        return boolType;
    }

    @Override
    public Type visit(DecExpr n)
    {
        return decType;
    }

    @Override
    public Type visit(StrExpr n)
    {
        return strType;
    }

    @Override
    public Type visit(Add e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Sub e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Mul e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Div e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Pos e)
    {
        return this.computeTypeOfUnaryExpr(e);
    }

    @Override
    public Type visit(Neg e)
    {
        return this.computeTypeOfUnaryExpr(e);
    }

    @Override
    public Type visit(Not e)
    {
        return this.computeTypeOfUnaryExpr(e);
    }

    @Override
    public Type visit(Gt e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Lt e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(GtEqu e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(LtEqu e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Equ e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(NotEqu e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(And e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Or e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visit(Ident n)
    {
        if (this.isIdentUndeclared(n))
        {
            this.messages.add(ql.semantics.errors.Error.undeclaredIdentifier(n.getId(), n.getLineNumber()));
            return undefType;
        }

        return this.questions.getType(n.getId());
    }

    private boolean isIdentUndeclared(Ident id)
    {
        return !(this.questions.contains(id.getId()));
    }

    // 1. Check if the operands are defined
    // 2. Check if the operands are of the allowed types
    // 3. Check if the operands are of the same type, e.g. no 1=="string"
    private Type computeTypeOfBinaryExpr(BinaryExpr e)
    {
        Type left = e.getLeft().accept(this);
        Type right = e.getRight().accept(this);

        if (left.isUndef() || right.isUndef())
        {
            return undefType;
        }

        if (!(this.isChildOfAllowedType(e, left)) || !(this.isChildOfAllowedType(e, right)))
        {
            return undefType;
        }

        Type leftPromoted = left.promoteTo(right);
        Type rightPromoted = right.promoteTo(left);

        if (!(this.areChildTypesConsistent(e, leftPromoted, rightPromoted)))
        {
            return undefType;
        }

        return e.getReturnType(leftPromoted);
    }

    // 1. Check if the operand is defined
    // 2. Check if the operand is of the correct type
    private Type computeTypeOfUnaryExpr(UnaryExpr e)
    {
        Type operand = e.getOperand().accept(this);

        if (operand.isUndef())
        {
            return undefType;
        }

        if (!(this.isChildOfAllowedType(e, operand)))
        {
            return undefType;
        }

        return e.getReturnType(operand);
    }

    private boolean isChildOfAllowedType(NaryExpr e, Type childType)
    {
        boolean isTypeAllowed = e.isTypeCompatibleWithExpr(childType);
        if (!(isTypeAllowed))
        {
            this.messages.add(Error.incorrectTypes(e.getClass().getSimpleName(), childType.getTitle(), e.getLineNumber()));
        }

        return isTypeAllowed;
    }

    private boolean areChildTypesConsistent(AstNode n, Type left, Type right)
    {
        boolean consistent = left.equals(right);
        if (!(consistent))
        {
            this.messages.add(Error.typeMismatch(
                    n.getClass().getSimpleName(), left.getTitle(), right.getTitle(), n.getLineNumber()));
        }

        return consistent;
    }
}
