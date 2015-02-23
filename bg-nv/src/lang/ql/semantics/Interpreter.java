package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;
import lang.ql.semantics.values.*;

import java.util.*;

/**
* Created by bore on 15/02/15.
*/
public class Interpreter implements Visitor<Void>
{
    private Stack<Value> valueStack;
    private ValueTable variableValues;
    private Map<String, Question> questions;

    public static void interpret(Form f)
    {
        Map<String, Question> questions = QuestionVisitor.getQuestions(f);
        Interpreter i = new Interpreter(questions);
        f.accept(i);
    }

    private Interpreter(Map<String, Question> questions)
    {
        this.questions = questions;
        this.valueStack = new Stack<Value>();
        this.variableValues = new ValueTable();
    }

    @Override
    public Void visit(Form f)
    {
        for(Statement s : f.getBody())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        Expr e = c.getCondition();
        e.accept(this);

        for (Statement s : c.getBody())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question n)
    {
        // TODO: no default value
        this.variableValues.storeValue(n.getId(), new IntegerValue(5));

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion n)
    {
        Expr e = n.getDefaultValue();
        e.accept(this);

        this.variableValues.storeValue(n.getId(), this.popFromStack());

        return null;
    }

    @Override
    public Void visit(IntExpr e)
    {
        this.pushToStack(new IntegerValue(e.getValue()));

        return null;
    }

    @Override
    public Void visit(StrExpr e)
    {
        this.pushToStack(new StringValue(e.getValue()));

        return null;
    }

    @Override
    public Void visit(BoolExpr e)
    {
        this.pushToStack(new BooleanValue(e.getValue()));

        return null;
    }

    @Override
    public Void visit(DecExpr e)
    {
        this.pushToStack(new DecimalValue(e.getValue()));

        return null;
    }

    @Override
    public Void visit(Ident e)
    {
        if (!(this.variableValues.valueExists(e.getId())))
        {
            Question q = this.questions.get(e.getId());
            q.accept(this);
        }
        Value v = this.variableValues.getValue(e.getId());
        this.pushToStack(v);

        return null;
    }

    @Override
    public Void visit(Add e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.add(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Sub e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.sub(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Mul e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.mul(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Div e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.div(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Neg e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.neg();
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Pos e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.pos();
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Not e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.not();
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Gt e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.gt(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Lt e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.lt(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(GtEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.gtEqu(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(LtEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.ltEqu(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Equ e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.equ(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(NotEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.notEqu(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(And e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.and(right);
        this.pushToStack(result);

        return null;
    }

    @Override
    public Void visit(Or e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.or(right);
        this.pushToStack(result);

        return null;
    }

    private void visitBinaryChildren(BinaryExpr e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);
    }

    private void pushToStack(Value result)
    {
        this.valueStack.push(result);
    }

    private Value popFromStack()
    {
        return this.valueStack.pop();
    }
}