package org.fugazi.ast.Type;

public class BoolType extends Type {

    public BoolType() {

    }

    @Override
    public String toString() {
        return "Bool";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof BoolType;
    }
}
