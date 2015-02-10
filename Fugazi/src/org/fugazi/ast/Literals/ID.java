package org.fugazi.ast.Literals;

/**
 * The identifier.
 */
public class ID {
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
}

