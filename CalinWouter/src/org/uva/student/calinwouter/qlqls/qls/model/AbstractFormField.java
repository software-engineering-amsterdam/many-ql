package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;

import java.util.HashMap;

// TODO check if invoking this model fails the interpreter.
public abstract class AbstractFormField<T> extends AbstractModel<T> {
<<<<<<< HEAD
    protected String ident;
    protected HashMap<Object, Object> arguments;
    int arg;
=======
    private String ident;
    protected HashMap<Object, Object> arguments;
    protected int arg;
>>>>>>> 1e619796b20c2a9af27a21f5360f9e0267b2206f

    @Override
    public void caseString(String string) {
        if (arg != 0) {
            super.caseString(string);
            return;
        }
        this.ident = string;
        arg++;
    }

    @Override
    public void caseHashMap(HashMap<Object, Object> hashMap) {
        if (arg != 1) {
            super.caseHashMap(hashMap);
            return;
        }
        this.arguments = hashMap;
        arg++;
    }

}
