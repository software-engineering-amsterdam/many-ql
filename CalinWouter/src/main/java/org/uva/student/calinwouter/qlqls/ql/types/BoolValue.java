package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class BoolValue extends Value {
    public static final TypeDescriptor BOOL_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesBoolean();
        }

        @Override
        public BoolValue getDefaultValue() {
            return new BoolValue(false);
        }

        @Override
        public boolean isAllowed(IAllowTypeChecker allowTypeChecker) {
            return allowTypeChecker.allowsBooleanValue();
        }

        @Override
        public String toString() {
            return "Boolean";
        }

        @Override
        public boolean equals(final Object obj) {
            if (!(obj instanceof TypeDescriptor)) {
                return false;
            }
            final TypeDescriptor otherType = (TypeDescriptor) obj;
            final Value otherDefaultValue = otherType.getDefaultValue();
            final Value thisDefaultValue = getDefaultValue();
            final BoolValue equalityComparisonValue = otherDefaultValue.eq(thisDefaultValue);
            return equalityComparisonValue.isTrue();
        }
    };

    @Override
    public Value or(Value value) {
        return new BoolValue((Boolean) getInternalValue() || (Boolean) value.getInternalValue());
    }

    @Override
    public Value and(Value value) {
        return new BoolValue((Boolean) getInternalValue() && (Boolean) value.getInternalValue());
    }

    @Override
    public BoolValue not() {
        return new BoolValue(!(Boolean) getInternalValue());
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesBoolean();
    }

    public boolean isTrue() {
        return (Boolean) getInternalValue();
    }

    public BoolValue(Boolean value) {
        super(value);
    }
}
