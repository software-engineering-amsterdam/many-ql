package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;

public class Negative extends Unary {

    public Negative(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "- " + this.expr.toString();
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNegative(this);
    }
}