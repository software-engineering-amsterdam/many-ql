package org.fugazi.evaluator;

public class IntValue extends ExpressionValue<Integer> {

    public IntValue(Integer _value) {
        super(_value);
    }

    public Integer getValue() {
        return this.value;
    }
}