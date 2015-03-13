package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interfaces.IQlRenderer;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.qls.exceptions.FieldNotFoundException;

public class QuestionField extends FormField {

    @Override
    public <T> T applyRenderer(IQlRenderer<T> iQlRenderer) throws FieldNotFoundException {
        return iQlRenderer.render(this);
    }

    public QuestionField(String lbl, String variable, TypeDescriptor<?> typeDescriptor, FormInterpreter formInterpreter) {
        super(lbl, variable, formInterpreter);
    }

}
