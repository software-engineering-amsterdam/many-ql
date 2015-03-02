package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;

public class BoolValue extends Value<Boolean> {
    public static final String TYPE_REFERENCE = "boolean";

    @Override
    public Value<?> or(Value<?> value) {
        if (value.getTypeModelClass() == Boolean.class) {
            if (getValue() == null)
                return new BoolValue(null);
            return new BoolValue(getValue() || (Boolean) value.getValue());
        }
        return super.or(value);
    }

    @Override
    public Value<?> and(Value<?> value) {
        if (value.getTypeModelClass() == Boolean.class) {
            if (getValue() == null)
                return new BoolValue(null);
            return new BoolValue(getValue() && (Boolean) value.getValue());
        }
        return super.and(value);
    }

    @Override
    public Value<?> not() {
        if (getValue() == null)
            return new BoolValue(null);
        return new BoolValue(!getValue());
    }

    @Override
    public Class<Boolean> getTypeModelClass() {
        return Boolean.class;
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesBoolean();
    }

    public BoolValue(Boolean value) {
        super(value);
    }
}
