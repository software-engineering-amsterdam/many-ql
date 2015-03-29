package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IAllowTypeChecker;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

public class StringValue extends Value {
    public static final ITypeDescriptor STRING_VALUE_TYPE_DESCRIPTOR = new ITypeDescriptor() {

        public void callTypeMethod(final ITypeCallback typeCallback) {
            typeCallback.usesString();
        }

        public StringValue getDefaultValue() {
            return new StringValue("");
        }

        public boolean isAllowed(IAllowTypeChecker allowTypeChecker) {
            return allowTypeChecker.allowsStringValue();
        }

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

        @Override
        public String toString() {
            return "String";
        }
    };

    @Override
    public void apply(ITypeCallback typeCallback) {
        typeCallback.usesString();
    }

    public StringValue(String value) {
        super(value);
    }
}
