package org.uva.student.calinwouter.qlqls.ql.types;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;

public class TBool extends TypeModel<Boolean> {

    @Override
    public TypeModel<?> or(TypeModel<?> typeModel) {
        if (typeModel.getTypeModelClass() == Boolean.class) {
            if (getValue() == null)
                return new TBool(null);
            return new TBool(getValue() || (Boolean) typeModel.getValue());
        }
        return super.or(typeModel);
    }

    @Override
    public TypeModel<?> and(TypeModel<?> typeModel) {
        if (typeModel.getTypeModelClass() == Boolean.class) {
            if (getValue() == null)
                return new TBool(null);
            return new TBool(getValue() && (Boolean) typeModel.getValue());
        }
        return super.and(typeModel);
    }

    @Override
    public TypeModel<?> not() {
        if (getValue() == null)
            return new TBool(null);
        return new TBool(!getValue());
    }

    @Override
    public Class<Boolean> getTypeModelClass() {
        return Boolean.class;
    }

    @Override
    public void apply(TypeCallback typeCallback) {
        typeCallback.usesBoolean();
    }

    public TBool(Boolean value) {
        super(value);
    }
}
