package lang.ql.semantics;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;
import lang.ql.semantics.errors.Error;
import lang.ql.semantics.errors.Message;
import lang.ql.semantics.errors.Warning;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class TypeChecker implements Visitor<Type>
{
    private SymbolTable symbolTable;
    private Question currentQuestion;
    private QuestionDependencies questionDependencies;
    private LabelMap labels;
    private List<Message> messages;
    
    public static List<Message> check(Form f)
    {
        SymbolResult symbolResult = SymbolVisitor.extract(f);
        if (!(symbolResult.getMessages().isEmpty()))
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
        this.messages = new ArrayList<Message>();
    }

    @Override
    public Type visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Type visit(IfCondition condition)
    {
        Type condType = condition.getCondition().accept(this);

        if (!(condType.equals(new BoolType())))
        {
            this.messages.add(Error.ifConditionShouldBeBoolean(condition.getLineNumber()));
        }

        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Type visit(Question q)
    {
        this.questionDependencies.addQuestion(q);
        this.labels.registerLabel(q);

        return null;
    }

    @Override
    public Type visit(CalculatedQuestion q)
    {
        this.setScopeForExpr(q);

        this.questionDependencies.addQuestion(q);
        this.labels.registerLabel(q);

        Type defined = q.getType();
        Type assigned = q.getDefaultValue().accept(this);

        if (!(defined.equals(assigned)))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(), assigned.getTitle(),
                    q.getLineNumber()));
        }

        this.resetScopeForExpr();

        return null;
    }

    @Override
    public Type visit(Ident n)
    {
        Type type = this.symbolTable.resolve(n.getId());
        if (type == null)
        {
            this.messages.add(Error.undeclaredIdentifier(n.getId(), n.getLineNumber()));
            return new UndefinedType();
        }

        if (this.currentQuestion != null)
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
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Sub e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Mul e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Div e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Pos e)
    {
        return this.visitUnaryExpr(e);
    }

    @Override
    public Type visit(Neg e)
    {
        return this.visitUnaryExpr(e);
    }

    @Override
    public Type visit(Not e)
    {
        return this.visitUnaryExpr(e);
    }

    @Override
    public Type visit(Gt e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Lt e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(GtEqu e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(LtEqu e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Equ e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(NotEqu e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(And e)
    {
        return this.visitBinaryExpr(e);
    }

    @Override
    public Type visit(Or e)
    {
        return this.visitBinaryExpr(e);
    }

    private Type visitBinaryExpr(BinaryExpr e)
    {
        Type left = e.getLeft().accept(this);
        Type right = e.getRight().accept(this);

        this.checkChildTypesConsistency(e, left, right);

        return this.checkTypeAndSetReturnType(e, left);
    }

    private Type visitUnaryExpr(UnaryExpr e)
    {
        Type operand = e.getOperand().accept(this);

        return this.checkTypeAndSetReturnType(e, operand);
    }

    private Type checkTypeAndSetReturnType(Expr e, Type childType)
    {
        String exprName = e.getClass().getSimpleName();
        Set<Type> types = ExprTypes.exprAllowedTypes.get(exprName);

        this.checkAllowedTypes(e, childType, types);

        Type returnType = childType;
        if (ExprTypes.exprReturnType.containsKey(exprName))
        {
            returnType = ExprTypes.exprReturnType.get(exprName);
        }

        return returnType;
    }

    private void checkChildTypesConsistency(AstNode n, Type leftChildType, Type rightChildType)
    {
        if (!(leftChildType.equals(rightChildType)))
        {
            this.messages.add(Error.typeMismatch(
                    n.getClass().getSimpleName(), leftChildType, rightChildType, n.getLineNumber()));
        }
    }

    private void checkAllowedTypes(Expr e, Type childType, Set<Type> allowedTypes)
    {
        if (!(allowedTypes.contains(childType)))
        {
            this.messages.add(Error.incorrectTypes(e.getClass().getSimpleName(), childType, e.getLineNumber()));
        }
    }

    private void setScopeForExpr(CalculatedQuestion q)
    {
        this.currentQuestion = q;
    }

    private void resetScopeForExpr()
    {
        this.currentQuestion = null;
    }

    private void checkForCyclicDependencies()
    {
        List<String> cyclicIds = this.questionDependencies.findCycle();
        if (cyclicIds != null)
        {
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
