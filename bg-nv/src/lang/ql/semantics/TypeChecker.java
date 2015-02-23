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
public class TypeChecker implements Visitor<Void>
{
    private SymbolTable symbolTable;
    private Stack<Type> typeStack;
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
        this.typeStack = new Stack<Type>();
        this.questionDependencies = new QuestionDependencies();
        this.labels = new LabelMap();
        this.messages = new ArrayList<Message>();
    }

    @Override
    public Void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition condition)
    {
        condition.getCondition().accept(this);

        Type type = this.popType();
        if (!(type.equals(new BoolType())))
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
    public Void visit(Question q)
    {
        this.questionDependencies.addQuestion(q);
        this.labels.registerLabel(q);

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.setScopeForExpr(q);

        this.questionDependencies.addQuestion(q);
        this.labels.registerLabel(q);

        q.getDefaultValue().accept(this);

        Type defined = q.getType();
        Type calculated = this.popType();

        if (!(defined.equals(calculated)))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(), calculated.getTitle(),
                    q.getLineNumber()));
        }

        this.resetScopeForExpr();

        return null;
    }

    @Override
    public Void visit(Ident n)
    {
        Type type = this.symbolTable.resolve(n.getId());
        if (type != null)
        {
            if (this.currentQuestion != null)
            {
                Question q = this.symbolTable.getQuestion(n.getId());
                this.questionDependencies.addDependency(this.currentQuestion, q);
            }

            this.pushType(type);
        }
        else
        {
            this.messages.add(Error.undeclaredIdentifier(n.getId(), n.getLineNumber()));
            this.pushType(new UndefinedType());
        }

        return null;
    }

    @Override
    public Void visit(IntExpr n)
    {
        this.pushType(new IntType());

        return null;
    }

    @Override
    public Void visit(BoolExpr n)
    {
        this.pushType(new BoolType());

        return null;
    }

    @Override
    public Void visit(DecExpr n)
    {
        this.pushType(new DecType());

        return null;
    }

    @Override
    public Void visit(StrExpr n)
    {
        this.pushType(new StrType());

        return null;
    }

    @Override
    public Void visit(Add e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Sub e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Mul e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Div e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Pos e)
    {
        this.visitUnaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Neg e)
    {
        this.visitUnaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Not e)
    {
        this.visitUnaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Gt e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Lt e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(GtEqu e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(LtEqu e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Equ e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(NotEqu e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(And e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    @Override
    public Void visit(Or e)
    {
        this.visitBinaryExpr(e);

        return null;
    }

    private void visitBinaryExpr(BinaryExpr e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Type right = this.popType();
        Type left = this.popType();

        this.checkChildTypesConsistency(e, left, right);

        this.checkTypeAndSetReturnType(e, left);
    }

    private void visitUnaryExpr(UnaryExpr e)
    {
        e.getOperand().accept(this);
        Type operand = this.popType();

        this.checkTypeAndSetReturnType(e, operand);
    }

    private void checkTypeAndSetReturnType(Expr e, Type childType)
    {
        String exprName = e.getClass().getSimpleName();
        Set<Type> types = ExprTypes.exprAllowedTypes.get(exprName);

        this.checkAllowedTypes(e, childType, types);

        Type returnType = childType;
        if (ExprTypes.exprReturnType.containsKey(exprName))
        {
            returnType = ExprTypes.exprReturnType.get(exprName);
        }

        this.pushType(returnType);
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

    private void pushType(Type type)
    {
        this.typeStack.push(type);
    }

    private Type popType()
    {
        return this.typeStack.pop();
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
