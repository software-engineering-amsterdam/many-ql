package org.fugazi.evaluator;

public class StringValue extends ExpressionValue<String> {

    public StringValue(String _value) {
        super(_value);
    }

    @Override
    public ExpressionValue add(ExpressionValue exprValue) {
        return this.addString((StringValue)exprValue);
    }

    public ExpressionValue addString(StringValue exprValue) {
        return new StringValue(this.getValue() + exprValue.getValue());
    }
}