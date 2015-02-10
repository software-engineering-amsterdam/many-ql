package org.uva.student.calinwouter.ql.ast.type;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.model.types.TInteger;
import org.uva.student.calinwouter.ql.interpreter.model.types.TString;

public class StringType extends Type<TString> {
    @Override
    public Class<TString> interpret(Environment environment) throws InterpretationException {
        return TString.class;
    }
}
