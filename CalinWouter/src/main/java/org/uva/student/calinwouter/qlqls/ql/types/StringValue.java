package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;

public class StringValue extends Value<String> {
    public static final String TYPE_REFERENCE = "string";

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
}
