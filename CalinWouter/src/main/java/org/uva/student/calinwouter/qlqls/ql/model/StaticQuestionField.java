package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public class StaticQuestionField extends AbstractStaticFormField {

    @Override
    public <T> T applyRenderer(IQLRenderer<T> iQLRenderer) {
        return iQLRenderer.render(this);
    }

    public StaticQuestionField(String label, String variable, TypeDescriptor typeDescriptor) {
        super(label, variable, typeDescriptor);
    }

}
