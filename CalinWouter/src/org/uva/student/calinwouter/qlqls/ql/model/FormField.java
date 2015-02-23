package org.uva.student.calinwouter.qlqls.ql.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TypeModel;

public abstract class FormField {
    private final FormInterpreter formInterpreter;
    private String lbl, variable;

    public abstract void render(IRenderer iRenderer);

    public TypeModel<?> getValue() {
        return formInterpreter.getField(variable);
    }

    public String getVariable() { return variable; }

    public void setValue(TypeModel<?> typeModel) {
        formInterpreter.setField(variable, typeModel);
    }

    public FormField(String lbl, String variable, FormInterpreter formInterpreter) {
        this.lbl = lbl;
        this.variable = variable;
        this.formInterpreter = formInterpreter;
    }
}
