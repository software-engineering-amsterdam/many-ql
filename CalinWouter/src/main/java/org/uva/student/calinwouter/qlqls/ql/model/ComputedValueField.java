package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

public class ComputedValueField extends FormField {

    @Override
    public void render(IRenderer iRenderer) {
        iRenderer.renderComputedValueField(this);
    }

    //public ComputedValueField(String lbl, String variable, TypeDescriptor<?> typeDescriptor, FormInterpreter formInterpreter) {
    public ComputedValueField(String lbl, String variable, TypeDescriptor<?> typeDescriptor, HeadlessFormInterpreter formInterpreter) {
        super(lbl, variable, formInterpreter);
    }

}
