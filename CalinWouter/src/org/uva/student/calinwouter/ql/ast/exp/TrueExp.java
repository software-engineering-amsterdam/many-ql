package org.uva.student.calinwouter.ql.ast.exp;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public class TrueExp extends Exp {
    @Override
    public TypeModel<?> interpret(Environment e) throws InterpretationException {
        return new TBool(true);
    }
}
