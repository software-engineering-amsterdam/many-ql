package org.fugazi.ast.literal;

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

    public <T> T accept(ILiteralVisitor<T> visitor) {
        return visitor.visitNUMBER(this);
    }
}

