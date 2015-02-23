package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.CalculatedQuestion;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.semantics.values.*;

/**
 * Created by bore on 23/02/15.
 */
public class Evaluator implements Visitor
{
    private EvalEnv env;

    public static void evaluate()
    {

    }

    private Evaluator(EvalEnv env)
    {
        this.env = env;
    }

    @Override
    public void visit(Form f)
    {

    }

    @Override
    public void visit(Question q)
    {

    }

    @Override
    public void visit(CalculatedQuestion q)
    {

    }

    @Override
    public void visit(IfCondition c)
    {

    }

    @Override
    public void visit(BoolExpr e)
    {
         new BooleanValue(e.getValue());
    }

    @Override
    public void visit(IntExpr e)
    {
        new IntegerValue(e.getValue());
    }

    @Override
    public void visit(DecExpr e)
    {
        new DecimalValue(e.getValue());
    }

    @Override
    public void visit(StrExpr e)
    {
        new StringValue(e.getValue());
    }

    @Override
    public void visit(Indent e)
    {

    }

    @Override
    public void visit(Neg e)
    {
        /* t */ e.getOperand().accept(this);
    }

    @Override
    public void visit(Pos e)
    {

    }

    @Override
    public void visit(Not e)
    {

    }



    @Override
    public void visit(Add e)
    {

    }

    @Override
    public void visit(Sub e)
    {

    }

    @Override
    public void visit(Mul e)
    {

    }

    @Override
    public void visit(Div e)
    {

    }

    @Override
    public void visit(Gt e)
    {

    }

    @Override
    public void visit(Lt e)
    {

    }

    @Override
    public void visit(GtEqu e)
    {

    }

    @Override
    public void visit(LtEqu e)
    {

    }

    @Override
    public void visit(Equ e)
    {

    }

    @Override
    public void visit(NotEqu e)
    {

    }

    @Override
    public void visit(And e)
    {

    }

    @Override
    public void visit(Or e)
    {

    }
}
