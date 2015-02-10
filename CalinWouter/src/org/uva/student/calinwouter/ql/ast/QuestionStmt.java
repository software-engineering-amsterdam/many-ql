package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class QuestionStmt extends Stmt {
    @Override
    public Object interpret(Environment environment) throws InterpretationException {
        return null;
    }
}
