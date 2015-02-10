package org.uva.student.calinwouter.ql.ast.type;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.model.types.TypeModel;

public class BooleanType extends Type<TBool> {
    @Override
    public Class<TBool> interpret(Environment environment) throws InterpretationException {
        return TBool.class;
    }
}
