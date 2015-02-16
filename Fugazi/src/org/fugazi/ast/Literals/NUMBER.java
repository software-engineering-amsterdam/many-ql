package org.fugazi.ast.Literals;

/**
 * The Number.
 */
public class NUMBER extends Literal {

    private String name;

    public NUMBER(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public <T> T accept(ILiteralVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

