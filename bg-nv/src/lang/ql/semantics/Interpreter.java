package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;
import lang.ql.semantics.values.*;

import java.util.*;

/**
* Created by bore on 15/02/15.
*/
public class Interpreter implements Visitor
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
    public void visit(Form f)
    {
        for(Statement s : f.getBody())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(IfCondition c)
    {
        Expr e = c.getCondition();
        e.accept(this);

        for (Statement s : c.getBody())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(Question n)
    {
        // TODO: no default value
        this.variableValues.storeValue(n.getId(), new IntegerValue(5));
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        Expr e = n.getDefaultValue();
        e.accept(this);

        this.variableValues.storeValue(n.getId(), this.popFromStack());
    }

    @Override
    public void visit(IntExpr e)
    {
        this.pushToStack(new IntegerValue(e.getValue()));
    }

    @Override
    public void visit(StrExpr e)
    {
        this.pushToStack(new StringValue(e.getValue()));
    }

    @Override
    public void visit(BoolExpr e)
    {
        this.pushToStack(new BooleanValue(e.getValue()));
    }

    @Override
    public void visit(DecExpr e)
    {
        this.pushToStack(new DecimalValue(e.getValue()));
    }

    @Override
    public void visit(Indent e)
    {
        if (!(this.variableValues.valueExists(e.getId())))
        {
            Question q = this.questions.get(e.getId());
            q.accept(this);
        }
        Value v = this.variableValues.getValue(e.getId());
        this.pushToStack(v);
    }

    @Override
    public void visit(Add e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.add(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Sub e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.sub(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Mul e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.mul(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Div e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.div(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Neg e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.neg();
        this.pushToStack(result);
    }

    @Override
    public void visit(Pos e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.pos();
        this.pushToStack(result);
    }

    @Override
    public void visit(Not e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.not();
        this.pushToStack(result);
    }

    @Override
    public void visit(Gt e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.gt(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Lt e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.lt(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(GtEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.gtEqu(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(LtEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.ltEqu(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Equ e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.equ(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(NotEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.notEqu(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(And e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.and(right);
        this.pushToStack(result);
    }

    @Override
    public void visit(Or e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.or(right);
        this.pushToStack(result);
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