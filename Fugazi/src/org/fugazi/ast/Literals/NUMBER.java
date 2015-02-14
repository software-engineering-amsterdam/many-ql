package org.fugazi.ast.Literals;

/**
 * The Number.
 */
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
    public <T> T accept(ILiteralVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

