package lang.ql.ast.expression;

import lang.ql.ast.visitor.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class SubtractionExpression extends BinaryOperatorExpression
{
    public SubtractionExpression(Expression left, Expression right)
    {
        super(left, right);
    }

    public void visit(Visitor visitor)
    {
        visitor.visit(this);
    }
}
