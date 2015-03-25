package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;

public abstract class AbstractStaticFormField {
    private String label, variable;
    private TypeDescriptor typeDescriptor;

    public abstract <T> T applyRenderer(IQLRenderer<T> iQLRenderer);

    public String getVariable() {
        return variable;
    }

    public String getLabel() {
        return label;
    }

    public TypeDescriptor getTypeDescriptor() {
        return typeDescriptor;
    }

    public AbstractStaticFormField(String label, String variable, TypeDescriptor typeDescriptor) {
        this.label = label;
        this.variable = variable;
        this.typeDescriptor = typeDescriptor;
    }
}
