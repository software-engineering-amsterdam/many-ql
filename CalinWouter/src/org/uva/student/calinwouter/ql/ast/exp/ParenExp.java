package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.ast.exp.Exp;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

// TODO perhaps remove?
public class ParenExp extends Exp {
    private final Exp exp;

    @Override
    public TypeModel<?> interpret(Environment e) throws InterpretationException {
        return exp.interpret(e);
    }

    public ParenExp(Exp exp) {
        this.exp = exp;
    }
}
