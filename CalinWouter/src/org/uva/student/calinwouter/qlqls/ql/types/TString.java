package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;

public class TString extends TypeModel<String> {

    @Override
    public TypeModel<?> add(TypeModel<?> typeModel) {
        if (typeModel.getTypeModelClass() == String.class) {
            if (getValue() == null)
                return new TString(null);
            return new TString(getValue() + typeModel.getValue());
        }
        return super.add(typeModel);
    }

    @Override
    public Class<String> getTypeModelClass() {
        return String.class;
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesString();
    }

    public TString(String value) {
        super(value);
    }
}
