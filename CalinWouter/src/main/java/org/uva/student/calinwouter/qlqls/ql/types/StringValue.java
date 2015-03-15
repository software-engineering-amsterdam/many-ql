package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class StringValue extends Value {
    public static final TypeDescriptor STRING_VALUE_TYPE_DESCRIPTOR = new TypeDescriptor() {
        @Override
        public void callTypeMethod(final TypeCallback typeCallback) {
            typeCallback.usesString();
        }

        @Override
        public StringValue getDefaultValue() {
            return new StringValue("");
        }
    };

    @Override
    public Value add(Value value) {
        return new StringValue((String) getValue() + value.getValue());
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesString();
    }

    public StringValue(String value) {
        super(value);
    }

    @Override
    public Value eq(Value value) {
        return new BoolValue(value.getValue().equals(getValue()));
    }

    public Value neq(Value value) {
        return new BoolValue(!value.getValue().equals(getValue()));
    }
}
