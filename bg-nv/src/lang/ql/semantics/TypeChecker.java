package lang.ql.semantics;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;
import lang.ql.semantics.errors.Error;
import lang.ql.semantics.errors.Messages;
import lang.ql.semantics.errors.Warning;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */

public class TypeChecker implements FormVisitor<Boolean>, StatVisitor<Boolean>, ExprVisitor<Type>
{
    private SymbolTable symbolTable;
    private Question currentQuestion;
    private QuestionDependencies questionDependencies;
    private LabelMap labels;
    private Messages messages;

    public static Messages check(Form f)
    {
        SymbolResult symbolResult = QuestionCollector.extract(f);

        if (symbolResult.containsErrors())
        {
            return symbolResult.getMessages();
        }

        SymbolTable table = symbolResult.getSymbolTable();
        TypeChecker typeChecker = new TypeChecker(table);
        f.accept(typeChecker);

        typeChecker.checkForLabelDuplication();
        typeChecker.checkForCyclicDependencies();

        return typeChecker.messages;
    }

    private TypeChecker(SymbolTable table)
    {
        this.symbolTable = table;
        this.questionDependencies = new QuestionDependencies();
        this.labels = new LabelMap();
        this.messages = new Messages();
    }

    private UndefinedType undefinedType()
    {
        return new UndefinedType();
    }

    @Override
    public Boolean visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            boolean r = statement.accept(this);
            if (!r)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(IfCondition condition)
    {
        Type condType = condition.getCondition().accept(this);

        if (condType.isUndef())
        {
            return false;
        }

        if (!(condType.isBool()))
        {
            this.messages.add(Error.ifConditionShouldBeBoolean(condition.getLineNumber()));
            return false;
        }

        for (Statement statement : condition.getBody())
        {
            boolean r = statement.accept(this);
            if (!r)
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Question q)
    {
        this.questionDependencies.addQuestion(q);
        this.labels.registerLabel(q);

        return true;
    }

    @Override
    public Boolean visit(CalculatedQuestion q)
    {
        this.questionDependencies.addQuestion(q);
        this.labels.registerLabel(q);
        Type defined = q.getType();

        this.setScopeForExpr(q);
        Type assigned = q.getCalculation().accept(this);
        assigned = assigned.promoteTo(defined);
        this.resetScopeForExpr();

        if (assigned.isUndef())
        {
            return false;
        }

        if (!(defined.equals(assigned)))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(),
                    assigned.getTitle(), q.getLineNumber()));

            return false;
        }

        return true;
    }

    @Override
    public Type visit(Ident n)
    {
        Type type = this.symbolTable.resolve(n.getId());
        if (type.isUndef())
        {
            this.messages.add(Error.undeclaredIdentifier(n.getId(), n.getLineNumber()));
            return new UndefinedType();
        }

        if (this.isScopeSet())
        {
            Question q = this.symbolTable.getQuestion(n.getId());
            this.questionDependencies.addDependency(this.currentQuestion, q);
        }

        return type;
    }

    @Override
    public Type visit(IntExpr n)
    {
        return new IntType();
    }

    @Override
    public Type visit(BoolExpr n)
    {
        return new BoolType();
    }

    @Override
    public Type visit(DecExpr n)
    {
        return new DecType();
    }

    @Override
    public Type visit(StrExpr n)
    {
        return new StrType();
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

    // 1. Check if the operands are defined
    // 2. Check if the operands are of the allowed types
    // 3. Check if the operands are of the same type, e.g. no 1=="string"
    private Type computeTypeOfBinaryExpr(BinaryExpr e)
    {
        Type left = e.getLeft().accept(this);
        Type right = e.getRight().accept(this);

        if (left.isUndef() || right.isUndef())
        {
            return undefinedType();
        }

        if (!(this.isChildOfAllowedType(e, left)) || !(this.isChildOfAllowedType(e, right)))
        {
            return undefinedType();
        }

        Type leftPromoted = left.promoteTo(right);
        Type rightPromoted = right.promoteTo(left);

        if (!(this.areChildTypesConsistent(e, leftPromoted, rightPromoted)))
        {
            return undefinedType();
        }

        return e.getComputedType(leftPromoted);
    }

    // 1. Check if the operand is defined
    // 2. Check if the operand is of the correct type
    private Type computeTypeOfUnaryExpr(UnaryExpr e)
    {
        Type operand = e.getOperand().accept(this);

        if (operand.isUndef())
        {
            return undefinedType();
        }

        if (!(this.isChildOfAllowedType(e, operand)))
        {
            return undefinedType();
        }

        return e.getComputedType(operand);
    }

    private boolean isChildOfAllowedType(NaryExpr e, Type childType)
    {
        boolean isTypeAllowed = e.isTypeAllowed(childType);
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

    private void setScopeForExpr(CalculatedQuestion q)
    {
        this.currentQuestion = q;
    }

    private void resetScopeForExpr()
    {
        this.currentQuestion = null;
    }

    private boolean isScopeSet()
    {
        return this.currentQuestion != null;
    }

    private void checkForCyclicDependencies()
    {
        if (this.questionDependencies.containsCycle())
        {
            List<String> cyclicIds = this.questionDependencies.getCycle();
            this.messages.add(Error.cyclicQuestions(cyclicIds));
        }
    }

    private void checkForLabelDuplication()
    {
        Set<List<String>> duplicates = this.labels.getDuplicateLabels();
        for (List<String> d : duplicates)
        {
            this.messages.add(Warning.labelDuplication(d));
        }
    }
}
