package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.typechecker.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;

public class IntegerValue extends Value<Integer> {
    public static final TypeDescriptor<IntegerValue> INTEGER_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor<IntegerValue>() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesInteger();
        }

        @Override
        public IntegerValue getDefaultValue() {
            return new IntegerValue(0);
        }

        @Override
        public boolean isAllowed(final IAllowTypeChecker allowable) {
            return allowable.allowsIntegerValue();
        }
    };

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

    @Override
    public TypeDescriptor<?> getTypeDescriptor() {
        return INTEGER_VALUE_TYPE_DESCRIPTOR;
    }
}
