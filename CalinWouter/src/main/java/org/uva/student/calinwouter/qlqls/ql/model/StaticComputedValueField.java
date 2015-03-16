package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public class StaticComputedValueField extends AbstractStaticFormField {


    public StaticComputedValueField(String lbl, String variable, TypeDescriptor typeDescriptor) {
        super(lbl, variable, typeDescriptor);
    }

    @Override
    public <T> T applyRenderer(IQLRenderer<T> iQLRenderer) throws FieldNotFoundException {
        return iQLRenderer.render(this);
    }
}
