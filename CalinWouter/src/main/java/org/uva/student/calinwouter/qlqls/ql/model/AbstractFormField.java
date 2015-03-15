package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQLRenderer;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public abstract class AbstractFormField {
    private String label, variable;

    public abstract <T> T applyRenderer(IQLRenderer<T> iQlRenderer) throws FieldNotFoundException;

    public String getVariable() {
        return variable;
    }

    public String getLabel() {
        return label;
    }

    public AbstractFormField(String label, String variable) {
        this.label = label;
        this.variable = variable;
    }
}
