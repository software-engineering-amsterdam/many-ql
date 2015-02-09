package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class AFormInterpreter implements InterpreterInterface<PForm> {

    @Override
    public void interprete(Environment environment, PForm form) {
        new PStmtlistInterpreter().interprete(environment, ((AForm) form).getStmtlist());
    }

}
