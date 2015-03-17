package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class IntegerValue extends Value {
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
            return o instanceof TypeDescriptor && ((TypeDescriptor) o).getDefaultValue() instanceof IntegerValue;
        }

        @Override
        public String toString() {
            return "Integer";
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
        final Object otherInternalValue = value.getValue();
        final Object myInternalValue = getValue();
        return new BoolValue(otherInternalValue.equals(myInternalValue));
    }

    public Value neq(Value value) {
        return new BoolValue(!value.getValue().equals(getValue()));
    }

    public IntegerValue(Integer value) {
        super(value);
    }
}
