package org.fugazi.ast.literal;

import org.fugazi.ast.IASTVisitor;

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
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitSTRING(this);
    }
}