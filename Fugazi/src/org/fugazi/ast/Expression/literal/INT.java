package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;

public class INT extends Literal {

    private final int value;

    public INT(int _value) {
        this.value = _value;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitINT(this);
    }
}

