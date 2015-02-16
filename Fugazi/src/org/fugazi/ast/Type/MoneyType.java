package org.fugazi.ast.type;

import org.fugazi.ast.IASTVisitor;

/**
 * The Money type.
 */
public class MoneyType extends Type {

    @Override
    public String toString() {
        return "Money";
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitMoneyType(this);
    }
}
