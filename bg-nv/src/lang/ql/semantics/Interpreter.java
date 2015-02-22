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
    private Map<String, Value> variableValues;
    private QuestErrInfo info;

    public Interpreter()
    {
        this.valueStack = new Stack<Value>();
        this.variableValues = new HashMap<String, Value>();
    }

    public Map<String, Value> getVariableValues()
    {
        return variableValues;
    }

    private void initializeQuestErrInfo(Form f)
    {
        if (this.info == null)
        {
            TypeChecker visitor = new TypeChecker();
            f.accept(visitor);
            this.info = visitor.getInfo();
        }
    }

    @Override
    public void visit(Form f)
    {
        this.initializeQuestErrInfo(f);

        if (!(this.info.getMessages().isEmpty()))
        {
            // TODO: handle semantic errors
            throw new IllegalStateException("Semantic errors");
        }

        for(Statement s : f.getStatements())
        {
            s.accept(this);
        }
        System.out.print("");
    }

    @Override
    public void visit(IfCondition c)
    {
        Expr e = c.getExpr();
        e.accept(this);

        for (Statement s : c.getStatements())
        {
            s.accept(this);
        }
    }

    @Override
    public void visit(Question n)
    {
        Value defaultValue = ValueFactory.makeValue(n.getType());
        this.variableValues.put(n.getId(), defaultValue);
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        Expr e = n.getExpr();
        e.accept(this);
//        if (this.questionDependencies.containsKey(n))
//        { //TODO: throw exception if not?
//            Set<Question> questions = this.questionDependencies.get(n);
//            //TODO: now what?
//        }
        this.variableValues.put(n.getId(), this.popFromStack());
    }

    @Override
    public void visit(IntExpr e)
    {
        this.valueStack.push(new IntegerValue(e.getValue()));
    }

    @Override
    public void visit(StrExpr e)
    {
        this.valueStack.push(new StringValue(e.getValue()));
    }

    @Override
    public void visit(BoolExpr e)
    {
        this.valueStack.push(new BooleanValue(e.getValue()));
    }

    @Override
    public void visit(DecExpr e)
    {
        this.valueStack.push(new DecimalValue(e.getValue()));
    }

    @Override
    public void visit(Indent e)
    {
        // TODO: get the Question expression based on the identifier and compute its value and put it in the variableValues
        if (!(this.variableValues.containsKey(e.getId())))
        {
            List<Question> qs = this.info.getQuestionsById(e.getId());
            assert qs.size() == 1;
            Question q = qs.get(0);
            q.accept(this);
        }
        Value v = this.variableValues.get(e.getId());
        this.valueStack.push(v);
    }

    @Override
    public void visit(Add e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.add(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Sub e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.sub(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Mul e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.mul(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Div e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.div(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Neg e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.neg();
        this.valueStack.push(result);
    }

    @Override
    public void visit(Pos e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.pos();
        this.valueStack.push(result);
    }

    @Override
    public void visit(Not e)
    {
        e.getOperand().accept(this);
        Value operand = this.popFromStack();
        Value result = operand.not();
        this.valueStack.push(result);
    }

    @Override
    public void visit(Gt e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.gt(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Lt e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.lt(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(GtEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.gtEqu(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(LtEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.ltEqu(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Equ e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.equ(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(NotEqu e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.notEqu(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(And e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.and(right);
        this.valueStack.push(result);
    }

    @Override
    public void visit(Or e)
    {
        this.visitBinaryChildren(e);
        Value right = this.popFromStack();
        Value left = this.popFromStack();

        Value result = left.or(right);
        this.valueStack.push(result);
    }

    private void visitBinaryChildren(BinaryExpr e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);
    }

    private Value popFromStack()
    {
        try
        {
            return this.valueStack.pop();
        }
        catch (EmptyStackException ex)
        {
            // TODO: try to recover
            throw ex;
        }
    }
}