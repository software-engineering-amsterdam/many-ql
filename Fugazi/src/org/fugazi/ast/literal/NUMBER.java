package org.fugazi.ast.literal;

import org.fugazi.ast.IASTVisitor;

public class NUMBER extends Literal {

    private final String value;

    public NUMBER(String _value) {
        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitNUMBER(this);
    }
}

