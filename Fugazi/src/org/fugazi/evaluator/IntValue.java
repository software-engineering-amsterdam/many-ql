package org.fugazi.evaluator;

public class IntValue extends ExpressionValue<Integer> {

    public IntValue(Integer _value) {
        super(_value);
    }

    /**
     * Add
     */
    @Override
    public ExpressionValue add(ExpressionValue exprValue) {
        return this.addInt((IntValue)exprValue);
    }

    @Override
    public ExpressionValue addInt(IntValue exprValue) {
        return new IntValue(this.value + exprValue.getValue());
    }

    /**
     * Sub
     */
    @Override
    public ExpressionValue sub(ExpressionValue exprValue) {
        return this.subInt((IntValue)exprValue);
    }

    @Override
    public ExpressionValue subInt(IntValue exprValue) {
        return new IntValue(this.value - exprValue.getValue());
    }

    /**
     * Mul
     */
    @Override
    public ExpressionValue mul(ExpressionValue exprValue) {
        return this.mulInt((IntValue)exprValue);
    }

    @Override
    public ExpressionValue mulInt(IntValue exprValue) {
        return new IntValue(this.value * exprValue.getValue());
    }

    /**
     * Div
     */
    @Override
    public ExpressionValue div(ExpressionValue exprValue) {
        return this.divInt((IntValue)exprValue);
    }

    @Override
    public ExpressionValue divInt(IntValue exprValue) {
        return new IntValue(this.value / exprValue.getValue());
    }

    @Override
    public ExpressionValue negative() {
        return new IntValue( - this.value );
    }

    @Override
    public ExpressionValue positive() {
        return new IntValue(this.value);
    }
}
