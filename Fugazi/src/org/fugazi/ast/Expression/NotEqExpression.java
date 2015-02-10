package org.fugazi.ast.Expression;

/**
 * The Less Equal '<='.
 */
public class NotEqExpression extends ComparisonExpression {

    public NotEqExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " != " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}