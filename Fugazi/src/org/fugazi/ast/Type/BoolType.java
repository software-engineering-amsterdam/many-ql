package org.fugazi.ast.Type;

public class BoolType extends Type {

    @Override
    public String toString() {
        return "Bool";
    }

    @Override
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
