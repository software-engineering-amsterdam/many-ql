package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;

public abstract class AbstractStaticFormField {
    private final String label, variable;
    private final ITypeDescriptor typeDescriptor;

    public abstract <T> T applyRenderer(IQLRenderer<T> iQLRenderer);

    public String getVariable() {
        return variable;
    }

    public String getLabel() {
        return label;
    }

    public ITypeDescriptor getTypeDescriptor() {
        return typeDescriptor;
    }

    public AbstractStaticFormField(String label, String variable, ITypeDescriptor typeDescriptor) {
        this.label = label;
        this.variable = variable;
        this.typeDescriptor = typeDescriptor;
    }
}
