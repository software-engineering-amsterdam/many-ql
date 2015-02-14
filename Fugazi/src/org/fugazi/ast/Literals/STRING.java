package org.fugazi.ast.Literals;

/**
 * The String.
 */
public class STRING extends Literal {

    // The value of the string
    private String value;

    public STRING(String _value) {
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

