package org.fugazi.ast.literal;

import org.fugazi.ast.IASTVisitor;

public class NUMBER extends Literal {

    // The value of the number.
    private String value;

    public NUMBER(String _value) {
        this.value = _value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitNUMBER(this);
    }
}

