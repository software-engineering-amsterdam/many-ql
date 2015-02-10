package org.fugazi.ast.Expression;

/**
 * The AND '&&'.
 */
public class AndExpression extends LogicalExpression {

    public AndExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " && " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}