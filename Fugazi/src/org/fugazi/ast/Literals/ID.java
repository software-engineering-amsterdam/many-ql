package org.fugazi.ast.Literals;

/**
 * The identifier.
 */
public class ID extends Literal {

    private String name;

    public ID(String name) {
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

