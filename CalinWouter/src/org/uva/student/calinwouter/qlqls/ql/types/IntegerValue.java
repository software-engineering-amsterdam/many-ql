package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;

public class IntegerValue extends Value<Integer> {
    public static final String TYPE_REFERENCE = "int";

    @Override
    public Value<?> add(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new IntegerValue(null);
            return new IntegerValue(getValue() + (Integer) value.getValue());
        }
        return super.add(value);
    }

    @Override
    public Value<?> sub(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new IntegerValue(null);
            return new IntegerValue(getValue() - (Integer) value.getValue());
        }
        return super.sub(value);
    }

    @Override
    public Value<?> mul(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new IntegerValue(null);
            return new IntegerValue(getValue() * (Integer) value.getValue());
        }
        return super.mul(value);
    }

    @Override
    public Value<?> div(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new IntegerValue(null);
            return new IntegerValue(getValue() / (Integer) value.getValue());
        }
        return super.div(value);
    }

    @Override
    public Value<?> mod(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new IntegerValue(null);
            return new IntegerValue(getValue() % (Integer) value.getValue());
        }
        return super.mod(value);
    }

    @Override
    public Class<Integer> getTypeModelClass() {
        return Integer.class;
    }

    @Override
    public Value<?> lt(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new BoolValue(null);
            return new BoolValue(getValue() < (Integer) value.getValue());
        }
        return super.lt(value);
    }

    @Override
    public Value<?> gt(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new BoolValue(null);
            return new BoolValue(getValue() > (Integer) value.getValue());
        }
        return super.gt(value);
    }

    @Override
    public Value<?> lte(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new BoolValue(null);
            return new BoolValue(getValue() <= (Integer) value.getValue());
        }
        return super.lte(value);
    }

    @Override
    public Value<?> gte(Value<?> value) {
        if (value.getTypeModelClass() == Integer.class) {
            if (getValue() == null)
                return new BoolValue(null);
            return new BoolValue(getValue() >= (Integer) value.getValue());
        }
        return super.gte(value);
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesInteger();
    }

    public IntegerValue(Integer value) {
        super(value);
    }
}
