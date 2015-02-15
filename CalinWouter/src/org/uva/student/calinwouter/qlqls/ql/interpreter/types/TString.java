package org.uva.student.calinwouter.qlqls.ql.interpreter.types;

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

    public TString(String value) {
        super(value);
    }
}
