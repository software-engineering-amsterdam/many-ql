package org.fugazi.ast.Expression.comparison;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The Greater '>'.
 */
public class GreaterExpression extends ComparisonExpression {

    public GreaterExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " > " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitGreaterExpression(this);
    }
}