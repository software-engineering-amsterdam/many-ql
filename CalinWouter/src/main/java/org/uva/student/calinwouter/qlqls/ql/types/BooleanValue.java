package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

public class BooleanValue extends Value {
    public static final ITypeDescriptor BOOL_VALUE_TYPE_DESCRIPTOR = new ITypeDescriptor() {

        public void callTypeMethod(final ITypeCallback typeCallback) {
            typeCallback.usesBoolean();
        }

        public BooleanValue getDefaultValue() {
            return new BooleanValue(false);
        }

        public boolean isAllowed(IAllowTypeChecker allowTypeChecker) {
            return allowTypeChecker.allowsBooleanValue();
        }

        @Override
        public String toString() {
            return "Boolean";
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

    @Override
    public Value or(Value value) {
        return new BooleanValue((Boolean) toJavaObject() || (Boolean) value.toJavaObject());
    }

    @Override
    public Value and(Value value) {
        return new BooleanValue((Boolean) toJavaObject() && (Boolean) value.toJavaObject());
    }

    @Override
    public BooleanValue not() {
        return new BooleanValue(!(Boolean) toJavaObject());
    }

    @Override
    public void apply(ITypeCallback typeCallback) {
        typeCallback.usesBoolean();
    }

    public boolean isTrue() {
        return (Boolean) toJavaObject();
    }

    public BooleanValue(Boolean value) {
        super(value);
    }
}
