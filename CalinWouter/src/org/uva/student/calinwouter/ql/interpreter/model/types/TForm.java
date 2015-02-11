package org.uva.student.calinwouter.ql.interpreter.model.types;

import org.uva.student.calinwouter.ql.interpreter.model.FormElementList;

import java.util.List;

public class TForm extends TypeModel<FormElementList> {

    @Override
    public Class<FormElementList> getTypeModelClass() {
        return FormElementList.class;
    }

    public TForm(FormElementList value) {
        super(value);
    }

}