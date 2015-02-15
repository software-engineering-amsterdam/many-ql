package org.fugazi.ast.Expression.numerical;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The Add '+'.
 */
public class AddExpression extends NumericalExpression {

    public AddExpression(Expression _leftExpr, Expression _rightExpr) {
        super(_leftExpr, _rightExpr);
    }

    @Override
    public String toString() {
        return this.leftExpr.toString() + " + " + this.rightExpr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitAddExpression(this);
    }
}