package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
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

        @Override
        public boolean isAllowed(IAllowTypeChecker allowTypeChecker) {
            return allowTypeChecker.allowsStringValue();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof StringValue;
        }

        @Override
        public String toString() {
            return "String";
        }
    };

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesString();
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

    public StringValue(String value) {
        super(value);
    }
}
