package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.IASTVisitor;

/**
 * The Positive '-()'.
 */
public class PosExpression extends UnaryExpression {

    public PosExpression(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "+ " + this.expr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitPosExpression(this);
    }
}