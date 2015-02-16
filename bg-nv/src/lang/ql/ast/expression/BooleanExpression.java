package lang.ql.ast.expression;

import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 10/02/15.
 */
public class BooleanExpression extends ConstantExpression<Boolean>
{
    public BooleanExpression(Boolean value)
    {
        super(value);
    }

    public void visit(Visitor visitor) { visitor.visit(this); }
}
