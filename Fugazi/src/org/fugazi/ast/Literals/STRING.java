package org.fugazi.ast.Literals;

/**
 * The String.
 */
public class STRING extends Literal {

    private String name;

    public STRING(String name) {
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

