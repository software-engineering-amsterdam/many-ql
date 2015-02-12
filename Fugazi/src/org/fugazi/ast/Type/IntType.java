package org.fugazi.ast.Type;

/**
 * The Integer type.
 */
public class IntType extends Type {

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
