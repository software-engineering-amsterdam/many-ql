package lang.ql.semantics;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;
import lang.ql.semantics.errors.Error;
import lang.ql.semantics.errors.Message;

import java.util.*;

/**
 * Created by bore on 13/02/15.
 */
public class TypeChecker implements Visitor
{
    private SymbolTable symbolTable;
    private Stack<Type> typeStack;
    private Question currentQuestion;
    private QuestionDependencies questionDependencies;
    private List<Message> messages;
    
    public static List<Message> check(Form f)
    {
        SymbolResult symbolResult = SymbolVisitor.extract(f);
        if (symbolResult.getMessages().isEmpty())
        {
            // TODO: symbol table has errors
        }

        SymbolTable table = symbolResult.getSymbolTable();
        TypeChecker typeChecker = new TypeChecker(table);
        f.accept(typeChecker);

        List<String> cyclicIds = typeChecker.questionDependencies.findCycle();
        if (cyclicIds != null)
        {
            typeChecker.messages.add(Error.cyclicQuestions(cyclicIds));
        }

        return typeChecker.messages;
    }

    private TypeChecker(SymbolTable table)
    {
        this.symbolTable = table;
        this.typeStack = new Stack<Type>();
        this.questionDependencies = new QuestionDependencies();
        this.messages = new ArrayList<Message>();
    }

    @Override
    public void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfCondition condition)
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
    }

    @Override
    public void visit(Question q)
    {
        this.questionDependencies.addQuestion(q);
    }

    @Override
    public void visit(CalculatedQuestion q)
    {
        this.setScopeForExpr(q);

        this.questionDependencies.addQuestion(q);

        q.getDefaultValue().accept(this);

        Type defined = q.getType();
        Type calculated = this.popType();

        if (!(defined.equals(calculated)))
        {
            this.messages.add(Error.identifierDefEvalMismatch(q.getId(), defined.getTitle(), calculated.getTitle(),
                    q.getLineNumber()));
        }

        this.resetScopeForExpr();
    }

    @Override
    public void visit(Indent n)
    {
        Type type = this.symbolTable.resolve(n.getId());
        if (type == null)
        {
            this.messages.add(Error.undeclaredIdentifier(n.getId(), n.getLineNumber()));
            type = this.tryToRecoverType();
        }

        if (this.currentQuestion != null)
        {
            Question q = this.symbolTable.getQuestion(n.getId());
            this.questionDependencies.addDependency(this.currentQuestion, q);
        }

        this.pushType(type);
    }

    private Type tryToRecoverType()
    {
        if (this.typeStack.empty())
        {
            if (this.currentQuestion != null)
            {
                return this.currentQuestion.getType();
            }

            return new BoolType();
        }

        return this.typeStack.peek();
    }

    @Override
    public void visit(IntExpr n)
    {
        this.pushType(new IntType());
    }

    @Override
    public void visit(BoolExpr n)
    {
        this.pushType(new BoolType());
    }

    @Override
    public void visit(DecExpr n)
    {
        this.pushType(new DecType());
    }

    @Override
    public void visit(StrExpr n)
    {
        this.pushType(new StrType());
    }

    @Override
    public void visit(Add e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Sub e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Mul e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Div e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Pos e)
    {
        this.visitUnaryExpr(e);
    }

    @Override
    public void visit(Neg e)
    {
        this.visitUnaryExpr(e);
    }

    @Override
    public void visit(Not e)
    {
        this.visitUnaryExpr(e);
    }

    @Override
    public void visit(Gt e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Lt e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(GtEqu e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(LtEqu e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Equ e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(NotEqu e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(And e)
    {
        this.visitBinaryExpr(e);
    }

    @Override
    public void visit(Or e)
    {
        this.visitBinaryExpr(e);
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
}
