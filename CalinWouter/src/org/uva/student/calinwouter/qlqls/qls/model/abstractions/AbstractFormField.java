package org.uva.student.calinwouter.qlqls.qls.model.abstractions;

import java.util.HashMap;

// TODO check if invoking this model fails the interpreter.
public abstract class AbstractFormField<T> extends AbstractComponent<T> {
    protected String ident;
    protected HashMap<Object, Object> arguments;
    private int arg;

    public String getFieldName() {
        return ident;
    }

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
