package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;

public class ComputedValueField extends FormField {

    @Override
    public void render(IRenderer iRenderer) {
        iRenderer.renderComputedValueField(this);
    }

    public ComputedValueField(String lbl, String variable, TypeDescriptor<?> typeDescriptor, FormInterpreter formInterpreter) {
        super(lbl, variable, formInterpreter);
    }

}
