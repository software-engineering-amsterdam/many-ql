package nl.uva.bromance.QL.expressions.primitives;

import nl.uva.bromance.QL.expressions.unary.Primitive;

/**
 * Created by Robert on 31-5-2015.
 */
public class NumberPrimitive extends Primitive {

    private int value;

    public NumberPrimitive(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    public NumberPrimitive addition(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value + rhs.getValue());
    }
    public NumberPrimitive division(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value / rhs.getValue());
    }
    public NumberPrimitive multiplication(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value * rhs.getValue());
    }
    public NumberPrimitive subtraction(NumberPrimitive rhs) {
        return new NumberPrimitive(this.value - rhs.getValue());
    }
    public BooleanPrimitive biggerThanOrEqual(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value >= rhs.getValue());
    }
    public BooleanPrimitive smallerThanOrEqual(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value <= rhs.getValue());
    }
    public BooleanPrimitive smallerThan(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value < rhs.getValue());
    }
    public BooleanPrimitive biggerThan(NumberPrimitive rhs){
        return new BooleanPrimitive(this.value > rhs.getValue());
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs) {
        return new BooleanPrimitive(value == ((NumberPrimitive)rhs).getValue());
    }

    @Override
    public Primitive evaluate() {
        return this;
    }
}
