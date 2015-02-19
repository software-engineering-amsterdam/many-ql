package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;

public class BOOL extends Literal {

    private final Boolean value;

    public BOOL(Boolean _value) {
        this.value = _value;
    }

    public Boolean getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitBOOL(this);
    }
}