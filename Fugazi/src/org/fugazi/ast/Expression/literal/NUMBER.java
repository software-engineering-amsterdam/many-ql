package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;

// TODO: create money and int and not only number?
public class NUMBER extends Literal {

    private final double value;

    public NUMBER(double _value) {
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
        return visitor.visitNUMBER(this);
    }
}
