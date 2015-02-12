package org.uva.student.calinwouter.ql.interpreter.components.types;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;

public class TInteger extends TypeModel<Integer> {

    @Override
    public TypeModel<?> add(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TInteger(getValue() + (Integer) typeModel.getValue());
        return super.add(typeModel);
    }

    @Override
    public TypeModel<?> sub(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TInteger(getValue() - (Integer) typeModel.getValue());
        return super.sub(typeModel);
    }

    @Override
    public TypeModel<?> mul(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TInteger(getValue() * (Integer) typeModel.getValue());
        return super.mul(typeModel);
    }

    @Override
    public TypeModel<?> div(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TInteger(getValue() / (Integer) typeModel.getValue());
        return super.div(typeModel);
    }

    @Override
    public TypeModel<?> mod(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TInteger(getValue() % (Integer) typeModel.getValue());
        return super.mod(typeModel);
    }

    @Override
    public Class<Integer> getTypeModelClass() {
        return Integer.class;
    }

    @Override
    public TypeModel<?> lt(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TBool(getValue() < (Integer) typeModel.getValue());
        return super.lt(typeModel);
    }

    @Override
    public TypeModel<?> gt(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TBool(getValue() > (Integer) typeModel.getValue());
        return super.gt(typeModel);
    }

    @Override
    public TypeModel<?> lte(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TBool(getValue() <= (Integer) typeModel.getValue());
        return super.lte(typeModel);
    }

    @Override
    public TypeModel<?> gte(TypeModel<?> typeModel) throws InterpretationException {
        if (getTypeModelClass() == Integer.class)
            return new TBool(getValue() >= (Integer) typeModel.getValue());
        return super.gte(typeModel);
    }

    public TInteger(Integer value) {
        super(value);
    }
}
