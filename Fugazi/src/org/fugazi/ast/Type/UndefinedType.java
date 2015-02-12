package org.fugazi.ast.Type;

/**
 * The Undefined type.
 */
public class UndefinedType extends Type {

    @Override
    public String toString() {
        return "Undefined";
    }

    @Override
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}