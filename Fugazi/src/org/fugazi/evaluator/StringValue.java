package org.fugazi.evaluator;

public class StringValue extends ExpressionValue<String> {

    public StringValue(String _value) {
        super(_value);
    }

    @Override
    public ExpressionValue add(ExpressionValue exprValue) {
        return exprValue.addString(this);
    }

    @Override
    public ExpressionValue addString(StringValue exprValue) {
        return new StringValue(exprValue.getValue() + this.getValue());
    }
}