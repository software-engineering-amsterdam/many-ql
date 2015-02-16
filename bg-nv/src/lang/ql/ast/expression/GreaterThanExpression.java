package lang.ql.ast.expression;

import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class GreaterThanExpression extends BinaryOperatorExpression
{
    public GreaterThanExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    public void visit(Visitor visitor) { visitor.visit(this); }
}
