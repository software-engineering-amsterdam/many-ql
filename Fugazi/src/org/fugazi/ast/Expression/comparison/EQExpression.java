package org.fugazi.ast.Expression.comparison;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.Expression.Expression;

/**
 * The Equal '=='.
 */
public class EQExpression extends ComparisonExpression {

    public EQExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + "==" + this.rightExpr.toString();
    }

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitEQExpression(this);
    }
}