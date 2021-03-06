package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

public class StaticComputedValueField extends AbstractStaticFormField {

    @Override
    public <T> T applyRenderer(IQLRenderer<T> iQLRenderer) {
        return iQLRenderer.render(this);
    }

    public StaticComputedValueField(String label, String variable, ITypeDescriptor typeDescriptor) {
        super(label, variable, typeDescriptor);
    }
}
