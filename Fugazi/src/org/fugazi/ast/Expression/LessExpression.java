package org.fugazi.ast.Expression;

/**
 * The Less '<'.
 */
public class LessExpression extends ComparisonExpression {

    public LessExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " < " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}