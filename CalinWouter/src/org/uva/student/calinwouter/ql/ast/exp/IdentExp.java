package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.ast.exp.Exp;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public class IdentExp extends Exp {
    private final String ident;

    @Override
    public TypeModel<?> interpret(Environment e) throws InterpretationException {
        return e.getEnvVars().get(ident);
    }

    public IdentExp(String ident) {
        this.ident = ident;
    }
}
