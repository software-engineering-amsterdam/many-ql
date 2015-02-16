package org.fugazi.ast.expression.literal;

import org.fugazi.ast.expression.IExpressionVisitor;

public class STRING extends Literal {

    private final String value;

    public STRING(String _value) {
        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}