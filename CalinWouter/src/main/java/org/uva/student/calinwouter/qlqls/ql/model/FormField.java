package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interfaces.IQlRenderer;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.Value;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public abstract class FormField {
    private String label, variable;

    public abstract <T> T applyRenderer(IQlRenderer<T> iQlRenderer) throws FieldNotFoundException;

    public String getVariable() {
        return variable;
    }

    public String getLabel() {
        return label;
    }

    public FormField(String label, String variable) {
        this.label = label;
        this.variable = variable;
    }
}
