package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class IdentExp extends Exp {
    private String ident;

    @Override
    public Object interprete(Environment e) throws InterpretationException {
        return e.getEnvVars().get(ident);
    }

    public IdentExp(String ident) {
        this.ident = ident;
    }
}

