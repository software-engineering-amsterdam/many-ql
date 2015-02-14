package org.fugazi.ast.Expression.unary;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.Expression.IExpressionVisitor;

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
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}