package org.fugazi.ast.Expression.numerical;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.Expression.IExpressionVisitor;

/**
 * The Div '/'.
 */
public class DivExpression extends NumericalExpression {

    public DivExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " / " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}