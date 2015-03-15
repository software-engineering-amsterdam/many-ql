package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public class QuestionField extends AbstractFormField {

    @Override
    public <T> T applyRenderer(IQLRenderer<T> iQLRenderer) throws FieldNotFoundException {
        return iQLRenderer.render(this);
    }

    public QuestionField(String lbl, String variable) {
        super(lbl, variable);
    }

}
