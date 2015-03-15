package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public class ComputedValueField extends AbstractFormField {


    public ComputedValueField(String lbl, String variable) {
        super(lbl, variable);
    }

    @Override
    public <T> T applyRenderer(IQLRenderer<T> iQlRenderer) throws FieldNotFoundException {
        return iQlRenderer.render(this);
    }
}
