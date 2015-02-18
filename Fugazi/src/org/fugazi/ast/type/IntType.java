package org.fugazi.ast.type;

public class IntType extends Type {

    @Override
    public String toString() {
        return "Int";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitIntType(this);
    }
}
