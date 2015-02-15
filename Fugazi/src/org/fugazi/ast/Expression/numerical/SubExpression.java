package org.fugazi.ast.Expression.numerical;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The Sub '-'.
 */
public class SubExpression extends NumericalExpression {

    public SubExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " - " + this.rightExpr.toString();
    }

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitSubExpression(this);
    }
}