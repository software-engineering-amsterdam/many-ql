package org.fugazi.ast.expression.comparison;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;

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

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitEQExpression(this);
    }
}