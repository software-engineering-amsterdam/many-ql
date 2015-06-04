package nl.uva.bromance.QL.expressions.primitives;

import nl.uva.bromance.QL.expressions.unary.Primitive;

public class StringPrimitive extends Primitive {

    private String value;

    public StringPrimitive(String value) {
        this.value = value;
    }

    String getValue(){
        return value;
    }

    @Override
    public BooleanPrimitive isEqual(Primitive rhs) {
        return new BooleanPrimitive(value.equals(((StringPrimitive) rhs).getValue()));
    }

    @Override
    public Primitive evaluate() {
        return this;
    }
}
