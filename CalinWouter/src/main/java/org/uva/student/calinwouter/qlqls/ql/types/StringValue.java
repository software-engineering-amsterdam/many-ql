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

        @Override
        public String toString() {
            return "String";
        }
    };

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesString();
    }

    public StringValue(String value) {
        super(value);
    }
}
