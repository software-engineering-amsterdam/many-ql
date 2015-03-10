package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;

public class QuestionField extends FormField {

    @Override
    public void render(IRenderer iRenderer) {
        iRenderer.renderQuestionField(this);
    }

    //public QuestionField(String lbl, String variable, TypeDescriptor<?> typeDescriptor, FormInterpreter formInterpreter) {
    public QuestionField(String lbl, String variable, TypeDescriptor<?> typeDescriptor, FormInterpreter formInterpreter) {
        super(lbl, variable, formInterpreter);
    }

}
