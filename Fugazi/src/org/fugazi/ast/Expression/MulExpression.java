package org.fugazi.ast.Expression;

/**
 * The Multiplication '*'.
 */
public class MulExpression extends NumericalExpression {

    public MulExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " * " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}