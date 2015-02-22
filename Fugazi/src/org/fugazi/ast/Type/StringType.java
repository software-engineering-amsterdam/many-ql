package org.fugazi.ast.type;

public class StringType extends Type {

    @Override
    public String toString() {
        return "String";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitStringType(this);
    }
}