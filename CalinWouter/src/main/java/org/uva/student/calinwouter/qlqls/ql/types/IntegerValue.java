package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class IntegerValue extends Value {
    // TODO here and at other places, add equals to typedescriptor!!
    public static final TypeDescriptor INTEGER_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesInteger();
        }

        @Override
        public IntegerValue getDefaultValue() {
            return new IntegerValue(0);
        }

        @Override
        public boolean isAllowed(IAllowTypeChecker allowTypeChecker) {
            return  allowTypeChecker.allowsIntegerValue();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof IntegerValue;
        }
    };

    @Override
    public Value add(Value value) {
        return new IntegerValue((Integer) getValue() + (Integer) value.getValue());
    }

    @Override
    public Value sub(Value value) {
        return new IntegerValue((Integer) getValue() - (Integer) value.getValue());
    }

    @Override
    public Value mul(Value value) {
        return new IntegerValue((Integer) getValue() * (Integer) value.getValue());
    }

    @Override
    public Value div(Value value) {
        return new IntegerValue((Integer) getValue() / (Integer) value.getValue());
    }

    @Override
    public Value mod(Value value) {
        return new IntegerValue((Integer) getValue() % (Integer) value.getValue());
    }

    @Override
    public Value lt(Value value) {
        return new BoolValue((Integer) getValue() < (Integer) value.getValue());
    }

    @Override
    public Value gt(Value value) {
        return new BoolValue((Integer) getValue() > (Integer) value.getValue());
    }

    @Override
    public Value lte(Value value) {
        return new BoolValue((Integer) getValue() <= (Integer) value.getValue());
    }

    @Override
    public Value gte(Value value) {
        return new BoolValue((Integer) getValue() >= (Integer) value.getValue());
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesInteger();
    }

    @Override
    public Value eq(Value value) {
        return new BoolValue(value.getValue().equals(getValue()));
    }

    public Value neq(Value value) {
        return new BoolValue(!value.getValue().equals(getValue()));
    }

    public IntegerValue(Integer value) {
        super(value);
    }
}
