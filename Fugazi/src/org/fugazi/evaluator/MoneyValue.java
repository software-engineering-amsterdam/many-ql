package org.fugazi.evaluator;

public class MoneyValue extends ExpressionValue<Double> {

    public MoneyValue(Double _value) {
        super(_value);
    }

    public Double getValue() {
        return this.value;
    }
}