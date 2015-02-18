package org.fugazi.evaluator;

public class BoolValue extends ExpressionValue<Boolean> {

    public BoolValue(Boolean _value) {
        super(_value);
    }

    @Override
    public ExpressionValue and(ExpressionValue exprValue) {
        return this.andBool((BoolValue)exprValue);
    }

    public ExpressionValue andBool(BoolValue exprValue) {
        return new BoolValue(value && exprValue.getValue());
    }

    @Override
    public ExpressionValue or(ExpressionValue exprValue) {
        return this.orBool((BoolValue) exprValue);
    }

    public ExpressionValue orBool(BoolValue exprValue) {
        return new BoolValue(value || exprValue.getValue());
    }

    @Override
    public ExpressionValue not() {
        return new BoolValue( !this.value );
    }
}