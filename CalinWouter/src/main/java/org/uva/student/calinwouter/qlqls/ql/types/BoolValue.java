package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.typechecker.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;

public class BoolValue extends Value<Boolean> {
    public static final TypeDescriptor<BoolValue> BOOL_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor<BoolValue>() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesBoolean();
        }

        @Override
        public BoolValue getDefaultValue() {
            return new BoolValue(false);
        }

        @Override
        public boolean isAllowed(final IAllowTypeChecker allowable) {
            return allowable.allowsBooleanValue();
        }
    };

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

    @Override
    public TypeDescriptor<?> getTypeDescriptor() {
        return BOOL_VALUE_TYPE_DESCRIPTOR;
    }
}