package org.fugazi.ast.Type;

/**
 * The Integer type.
 */
public class IntType extends Type {

    public IntType() {

    }

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof IntType;
    }
}
