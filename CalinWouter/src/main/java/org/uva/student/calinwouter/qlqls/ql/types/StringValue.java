package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.typechecker.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;

public class StringValue extends Value<String> {
    public static final TypeDescriptor<StringValue> STRING_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor<StringValue>() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesString();
        }

        @Override
        public StringValue getDefaultValue() {
            return new StringValue("");
        }

        @Override
        public boolean isAllowed(final IAllowTypeChecker allowable) {
            return allowable.allowsStringValue();
        }
    };

    @Override
    public Value<?> add(Value<?> value) {
        if (value.getTypeModelClass() == String.class) {
            if (getValue() == null)
                return new StringValue(null);
            return new StringValue(getValue() + value.getValue());
        }
        return super.add(value);
    }

    @Override
    public Class<String> getTypeModelClass() {
        return String.class;
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesString();
    }

    public StringValue(String value) {
        super(value);
    }

    @Override
    public TypeDescriptor<?> getTypeDescriptor() {
        return STRING_VALUE_TYPE_DESCRIPTOR;
    }
}
