package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class AndExp extends Exp {
    private Exp l, r;

    private Boolean calc(Boolean l, Boolean r) {
        return l && r;
    }

    private Object calc(Object l, Object r) {
        throw new ClassCastException();
    }

    @Override
    public Object interprete(Environment e) throws InterpretationException {
        return calc(l.interprete(e), r.interprete(e));
    }

    public AndExp(Exp l, Exp r) {
        this.l = l;
        this.r = r;
    }
}
