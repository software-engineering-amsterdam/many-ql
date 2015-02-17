package org.fugazi.ast.type;

public class MoneyType extends Type {

    @Override
    public String toString() {
        return "Money";
    }

    public <T> T accept(ITypeVisitor<T> visitor) {
        return visitor.visitMoneyType(this);
    }
}
