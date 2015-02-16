package lang.ql.ast.visitor;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;

/**
 * Created by bore on 13/02/15.
 */
// TODO: Remove this class
public abstract class VisitorAbstract implements Visitor
{
    @Override
    public void visit(Form n)
    {

    }

    @Override
    public void visit(Question n)
    {

    }

    @Override
    public void visit(CalculatedQuestion n)
    {

    }

    @Override
    public void visit(IfCondition n)
    {

    }

    @Override
    public void visit(Expression n)
    {

    }

    @Override
    public void visit(BooleanExpression n)
    {

    }

    @Override
    public void visit(IntegerExpression n)
    {

    }

    @Override
    public void visit(DecimalExpression n)
    {

    }

    @Override
    public void visit(StringExpression n)
    {

    }

    @Override
    public void visit(AdditionExpression n)
    {

    }

    @Override
    public void visit(SubtractionExpression n)
    {

    }

    @Override
    public void visit(GreaterThanExpression n)
    {

    }

    @Override
    public void visit(UnaryMinusExpression n)
    {

    }

    @Override
    public void visit(UnaryPlusExpression n)
    {

    }

    @Override
    public void visit(VariableExpression n)
    {

    }
}
