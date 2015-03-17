package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public class StaticQuestionField extends AbstractStaticFormField {

    @Override
    public <T> T applyRenderer(IQLRenderer<T> iQLRenderer) throws FieldNotFoundException {
        return iQLRenderer.render(this);
    }

    public StaticQuestionField(String label, String variable, TypeDescriptor typeDescriptor) {
        super(label, variable, typeDescriptor);
    }

}
