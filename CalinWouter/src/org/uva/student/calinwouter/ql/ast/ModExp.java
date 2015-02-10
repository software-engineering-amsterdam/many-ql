package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class ModExp extends Exp {
    private Exp l, r;

    private Integer calc(Integer l, Integer r) {
        return l % r;
    }

    private Object calc(Object l, Object r) {
        throw new ClassCastException();
    }

    @Override
    public Object interpret(Environment e) throws InterpretationException {
        return calc(l.interpret(e), r.interpret(e));
    }

    public ModExp(Exp l, Exp r) {
        this.l = l;
        this.r = r;
    }
}


