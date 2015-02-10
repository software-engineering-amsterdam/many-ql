package org.fugazi.ast.Type;

/**
 * The Money type.
 */
public class MoneyType extends Type {

    public MoneyType() {

    }

    @Override
    public String toString() {
        return "Money";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof MoneyType;
    }
}
