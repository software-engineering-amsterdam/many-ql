package org.uva.student.calinwouter.ql.interpreter.model;

import org.uva.student.calinwouter.ql.interpreter.model.types.TForm;
import org.uva.student.calinwouter.ql.interpreter.model.types.TFormElement;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

import java.util.HashMap;
import java.util.LinkedList;

public class Environment {
    private HashMap<String, TypeModel<?>> envVars;

    private TForm form;

    public HashMap<String, TypeModel<?>> getEnvVars() { return envVars; }

    public TForm getForm() { return form; }

    public void setForm(TForm form) { this.form = form; }

    public Environment() {
        envVars = new HashMap<String, TypeModel<?>>();
    }
}
