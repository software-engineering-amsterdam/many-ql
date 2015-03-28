package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

public class IntegerValue extends Value {
    public static final ITypeDescriptor INTEGER_VALUE_TYPE_DESCRIPTOR = new ITypeDescriptor() {
        @Override
        public void callTypeMethod(final ITypeCallback typeCallback) {
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
        public String toString() {
            return "Integer";
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof ITypeDescriptor)) {
                return false;
            }
            final ITypeDescriptor otherType = (ITypeDescriptor) obj;
            final Value otherDefaultValue = otherType.getDefaultValue();
            final Value thisDefaultValue = getDefaultValue();
            final BoolValue equalityComparisonValue = otherDefaultValue.eq(thisDefaultValue);
            return equalityComparisonValue.isTrue();
        }
    };

    @Override
    public Value add(Value value) {
        return new IntegerValue((Integer) getInternalValue() + (Integer) value.getInternalValue());
    }

    @Override
    public Value sub(Value value) {
        return new IntegerValue((Integer) getInternalValue() - (Integer) value.getInternalValue());
    }

    @Override
    public Value mul(Value value) {
        return new IntegerValue((Integer) getInternalValue() * (Integer) value.getInternalValue());
    }

    @Override
    public Value div(Value value) {
        return new IntegerValue((Integer) getInternalValue() / (Integer) value.getInternalValue());
    }

    @Override
    public Value mod(Value value) {
        return new IntegerValue((Integer) getInternalValue() % (Integer) value.getInternalValue());
    }

    @Override
    public BoolValue lt(Value value) {
        return new BoolValue((Integer) getInternalValue() < (Integer) value.getInternalValue());
    }

    @Override
    public BoolValue gt(Value value) {
        return new BoolValue((Integer) getInternalValue() > (Integer) value.getInternalValue());
    }

    @Override
    public BoolValue lte(Value value) {
        return new BoolValue((Integer) getInternalValue() <= (Integer) value.getInternalValue());
    }

    @Override
    public BoolValue gte(Value value) {
        return new BoolValue((Integer) getInternalValue() >= (Integer) value.getInternalValue());
    }

    @Override
    public void apply(ITypeCallback typeCallback) {
        typeCallback.usesInteger();
    }

    public IntegerValue(Integer value) {
        super(value);
    }
}
