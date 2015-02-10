package org.fugazi.ast.Type;

/**
 * The Undefined type.
 */
public class UndefinedType extends Type {

    public UndefinedType() {

    }

    @Override
    public String toString() {
        return "Undefined"
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof UndefinedType;
    }
}
