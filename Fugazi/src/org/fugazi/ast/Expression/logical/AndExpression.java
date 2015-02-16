package org.fugazi.ast.expression.logical;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.IASTVisitor;

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
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitAndExpression(this);
    }
}