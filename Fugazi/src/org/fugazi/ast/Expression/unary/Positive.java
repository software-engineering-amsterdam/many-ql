package org.fugazi.ast.expression.unary;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;

public class Positive extends Unary {

    public Positive(Expression _expr) {
        super(_expr);
    }

    @Override
    public String toString() {
        return "+ " + this.expr.toString();
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitPositive(this);
    }
}