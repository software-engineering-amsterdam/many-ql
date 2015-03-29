package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

public class IntegerValue extends Value {
    public static final ITypeDescriptor INTEGER_VALUE_TYPE_DESCRIPTOR = new ITypeDescriptor() {

        public void callTypeMethod(final ITypeCallback typeCallback) {
            typeCallback.usesInteger();
        }

        public IntegerValue getDefaultValue() {
            return new IntegerValue(0);
        }

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
            final BooleanValue equalityComparisonValue = otherDefaultValue.valueEquals(thisDefaultValue);
            return equalityComparisonValue.isTrue();
        }
    };

    public Value add(Value value) {
        return new IntegerValue((Integer) toJavaObject() + (Integer) value.toJavaObject());
    }

    public Value subtract(Value value) {
        return new IntegerValue((Integer) toJavaObject() - (Integer) value.toJavaObject());
    }

    public Value multiply(Value value) {
        return new IntegerValue((Integer) toJavaObject() * (Integer) value.toJavaObject());
    }

    public Value divide(Value value) {
        return new IntegerValue((Integer) toJavaObject() / (Integer) value.toJavaObject());
    }

    public Value modulo(Value value) {
        return new IntegerValue((Integer) toJavaObject() % (Integer) value.toJavaObject());
    }

    public BooleanValue lesserThan(Value value) {
        return new BooleanValue((Integer) toJavaObject() < (Integer) value.toJavaObject());
    }

    public BooleanValue greaterThan(Value value) {
        return new BooleanValue((Integer) toJavaObject() > (Integer) value.toJavaObject());
    }

    public BooleanValue lesserThanOrEquals(Value value) {
        return new BooleanValue((Integer) toJavaObject() <= (Integer) value.toJavaObject());
    }

    public BooleanValue greaterThanOrEquals(Value value) {
        return new BooleanValue((Integer) toJavaObject() >= (Integer) value.toJavaObject());
    }

    @Override
    public void apply(ITypeCallback typeCallback) {
        typeCallback.usesInteger();
    }

    public IntegerValue(Integer value) {
        super(value);
    }
}
