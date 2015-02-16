package org.fugazi.evaluator;

public class StringValue extends ExpressionValue<String> {

    public StringValue(String _value) {
        super(_value);
    }

    public String getValue() {
        return this.value;
    }
}