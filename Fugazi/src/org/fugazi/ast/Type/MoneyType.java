package org.fugazi.ast.Type;

/**
 * The Money type.
 */
public class MoneyType extends Type {

    @Override
    public String toString() {
        return "Money";
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
