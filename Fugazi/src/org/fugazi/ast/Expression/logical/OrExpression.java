package org.fugazi.ast.Expression.logical;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.Expression.IExpressionVisitor;

/**
 * The OR '||'.
 */
public class OrExpression extends LogicalExpression {

    public OrExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " || " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}