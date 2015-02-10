package org.uva.student.calinwouter.ql.ast.type;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.model.types.TInteger;

public class IntegerType extends Type<TInteger> {
    @Override
    public Class<TInteger> interpret(Environment environment) throws InterpretationException {
        return TInteger.class;
    }
}
