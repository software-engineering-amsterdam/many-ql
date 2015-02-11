package org.uva.student.calinwouter.ql.interpreter.model.types;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;

public class TString extends TypeModel<String> {

    @Override
    public TypeModel<?> add(TypeModel<?> typeModel) throws InterpretationException {
        if (typeModel.getTypeModelClass() == String.class)
            return new TString(getValue() + (String) typeModel.getValue());
        return super.add(typeModel);
    }

    @Override
    public Class<String> getTypeModelClass() {
        return String.class;
    }

    public TString(String value) {
        super(value);
    }
}
