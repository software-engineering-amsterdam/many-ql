package org.fugazi.ast.Type;

import org.fugazi.ast.IASTVisitor;

/**
 * The Money type.
 */
public class MoneyType extends Type {

    @Override
    public String toString() {
        return "Money";
    }

    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitMoneyType(this);
    }
}
