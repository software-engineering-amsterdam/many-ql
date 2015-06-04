package nl.uva.bromance.QL.expressions.primitives;

import nl.uva.bromance.QL.expressions.unary.Primitive;

public class BooleanPrimitive extends Primitive {

    private boolean value;

    boolean getValue(){
        return value;
    }

    public  BooleanPrimitive(boolean value){
        this.value = value;
    }

    public BooleanPrimitive or(BooleanPrimitive rhs){
        return new BooleanPrimitive(this.value || rhs.getValue());
    }

    public BooleanPrimitive and(BooleanPrimitive rhs){
        return new BooleanPrimitive(this.value && rhs.getValue());
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs) {
        return new BooleanPrimitive(value == ((BooleanPrimitive)rhs).getValue());
    }

    public void invert()
    {
        this.value = !this.value;
    }

    @Override
    public Primitive evaluate() {
        return this;
    }
}
