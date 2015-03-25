package ql.semantics;

import ql.ast.expression.*;
import ql.ast.type.*;
import ql.semantics.errors.Error;
import ql.semantics.errors.Messages;

/**
 * Created by bore on 16/03/15.
 */
public class TypeDeducer extends DefaultExprVisitor<Type>
{
    private final static BoolType boolType = new BoolType();
    private final static StrType strType = new StrType();
    private final static IntType intType = new IntType();
    private final static DecType decType = new DecType();
    private final static UndefType undefType = new UndefType();

    private final Questions questions;
    private final Messages messages;

    public static Type deduceType(Expr e, Questions questions, Messages messages)
    {
        TypeDeducer deducer = new TypeDeducer(questions, messages);
        return e.accept(deducer);
    }

    private TypeDeducer(Questions questions, Messages messages)
    {
        this.questions = questions;
        this.messages = messages;
    }

    @Override
    public Type visitBinary(BinaryExpr e)
    {
        return this.computeTypeOfBinaryExpr(e);
    }

    @Override
    public Type visitUnary(UnaryExpr e)
    {
        return this.computeTypeOfUnaryExpr(e);
    }

    @Override
    public Type visit(BoolExpr n)
    {
        return boolType;
    }

    @Override
    public Type visit(IntExpr n)
    {
        return intType;
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
    public Type visit(Ident n)
    {
        if (this.isIdentUndeclared(n))
        {
            this.messages.add(ql.semantics.errors.Error.undeclaredIdentifier(n.getId(), n.getLineNumber()));
            return undefType;
        }

        return this.questions.getType(n.getId());
    }

    @Override
    public Type visitDefault(Expr e)
    {
        throw new IllegalStateException("Expr is unhandled");
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
            // error is already logged, so just propagate it upwards
            return undefType;
        }

        if (this.isChildTypeIncompatibleWithExpr(e, left))
        {
            this.addIncorrectTypeError(e, left);
            return undefType;
        }

        if (this.isChildTypeIncompatibleWithExpr(e, right))
        {
            this.addIncorrectTypeError(e, right);
            return undefType;
        }

        Type leftPromoted = left.promoteTo(right);
        Type rightPromoted = right.promoteTo(left);

        if (this.areChildTypesInconsistent(leftPromoted, rightPromoted))
        {
            this.messages.add(Error.typeMismatch(e.getClass().getSimpleName(), left.getTitle(),
                    right.getTitle(), e.getLineNumber()));

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
            // error is already logged, so just propagate it upwards
            return undefType;
        }

        if (this.isChildTypeIncompatibleWithExpr(e, operand))
        {
            this.addIncorrectTypeError(e, operand);
            return undefType;
        }

        return e.getReturnType(operand);
    }

    private void addIncorrectTypeError(NaryExpr e, Type childType)
    {
        this.messages.add(Error.incorrectTypes(e.getClass().getSimpleName(), childType.getTitle(), e.getLineNumber()));
    }

    private boolean isChildTypeIncompatibleWithExpr(NaryExpr e, Type childType)
    {
        return !(e.isTypeCompatibleWithExpr(childType));
    }

    private boolean areChildTypesInconsistent(Type left, Type right)
    {
        return !(left.equals(right));
    }
}
