package org.fugazi.ast.Type;

/**
 * The Boolean type.
 */
public class BoolType extends Type {

    public BoolType() {

    }

    @Override
    public String toString() {
        return "bool"
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof BoolType;
    }
}
