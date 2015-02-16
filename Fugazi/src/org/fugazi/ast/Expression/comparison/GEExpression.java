package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The Greater Equal '>='.
 */
public class GEExpression extends ComparisonExpression {

    public GEExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " >= " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitGEExpression(this);
    }
}