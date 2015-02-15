package org.fugazi.ast.Expression.comparison;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

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

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitLessExpression(this);
    }
}