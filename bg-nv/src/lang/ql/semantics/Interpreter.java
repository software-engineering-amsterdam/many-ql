package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;
import lang.ql.semantics.values.*;

import java.util.*;

/**
 * Created by bore on 15/02/15.
 */
public class Interpreter extends VisitorAbstract
{
    private Stack<Value> valueStack;
    private Map<String, Value> variableValues;

    public Interpreter()
    {
        this.valueStack = new Stack<Value>();
        this.variableValues = new HashMap<String, Value>();
    }

    @Override
    public void visit(Form f)
    {
        for(Statement s : f.getStatements())
        {
            s.accept(this);
        }
        System.out.print("");
    }

    @Override
    public void visit(IfCondition c)
    {
        Expression e = c.getExpression();
        e.accept(this);

        for(Statement s : c.getStatements())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(Question n)
    {
        Value defaultValue = this.getDefaultValue(n.getQuestionType());
        this.variableValues.put(n.getId(), defaultValue);
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        Expression e = n.getExpression();
        e.accept(this);
        this.variableValues.put(n.getId(), this.popFromStack());
    }

    @Override
    public void visit(IntegerExpr e)
    {
        this.valueStack.push(new IntegerValue(e.getValue()));
    }

    @Override
    public void visit(StringExpr e)
    {
        this.valueStack.push(new StringValue(e.getValue()));
    }

    @Override
    public void visit(BooleanExpr e)
    {
        this.valueStack.push(new BooleanValue(e.getValue()));
    }

    @Override
    public void visit(DecimalExpr e)
    {
        this.valueStack.push(new DecimalValue(e.getValue()));
    }

    @Override
    public void visit(Variable e)
    {
        Value v = this.variableValues.get(e.getId());
        this.valueStack.push(v);
    }

    @Override
    public void visit(Add e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.add(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Sub e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);

        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.subtract(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Neg e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.unaryMinus();
        this.valueStack.push(result);
    }

    private Value getDefaultValue(QuestionType type)
    {
        if (type == QuestionType.BOOLEAN)
        {
            return BooleanValue.getDefaultValue();
        }

        if (type == QuestionType.STRING)
        {
            return StringValue.getDefaultValue();
        }

        if (type == QuestionType.INTEGER)
        {
            return IntegerValue.getDefaultValue();
        }

        return DecimalValue.getDefaultValue();
    }

    private Value popFromStack()
    {
        try
        {
            return this.valueStack.pop();
        }
        catch (EmptyStackException ex)
        {
            throw ex;
        }
    }
}