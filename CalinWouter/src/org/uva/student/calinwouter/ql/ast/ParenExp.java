package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class ParenExp extends Exp{
    private Exp e;

    public Object interprete(Environment environment) throws InterpretationException {
        return e.interprete(environment);
    }

    public ParenExp(Exp e){
        this.e = e;
    }

}
