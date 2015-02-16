package org.fugazi.ast.Type;

/**
 * The String type.
 */
public class StringType extends Type {

    @Override
    public String toString() {
        return "String";
    }

    @Override
    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
