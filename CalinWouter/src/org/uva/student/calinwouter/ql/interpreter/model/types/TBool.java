package org.uva.student.calinwouter.ql.interpreter.model.types;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;

public class TBool extends TypeModel<Boolean> {

    @Override
    public TypeModel<?> or(TypeModel<?> typeModel) throws InterpretationException {
        if (typeModel.getTypeModelClass() == Boolean.class)
            return new TBool(getValue() || (Boolean) typeModel.getValue());
        return super.add(typeModel);
    }

    @Override
    public TypeModel<?> and(TypeModel<?> typeModel) throws InterpretationException {
        if (typeModel.getTypeModelClass() == Boolean.class)
            return new TBool(getValue() && (Boolean) typeModel.getValue());
        return super.add(typeModel);
    }

    @Override
    public TypeModel<?> not() throws InterpretationException {
        if (getTypeModelClass() == Boolean.class)
            return new TBool(!getValue());
        return super.not();
    }

    @Override
    public Class<Boolean> getTypeModelClass() {
        return Boolean.class;
    }

    public TBool(Boolean value) {
        super(value);
    }
}
