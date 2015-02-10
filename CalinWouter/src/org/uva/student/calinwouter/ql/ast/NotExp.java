package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class NotExp extends Exp {
    private Exp exp;

    private Boolean calc(Boolean b) {
        return !b;
    }

    private Object calc(Object o) {
        throw new ClassCastException();
    }

    @Override
    public Object interpret(Environment e) throws InterpretationException {
        return calc(exp.interpret(e));
    }

    public NotExp(Exp exp) {
        this.exp = exp;
    }
}

