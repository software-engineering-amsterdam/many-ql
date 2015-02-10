package org.uva.student.calinwouter.ql.interpreter;

import org.uva.student.calinwouter.ql.generated.node.AFormBegin;
import org.uva.student.calinwouter.ql.generated.node.PForm;
import org.uva.student.calinwouter.ql.generated.node.Start;
import org.uva.student.calinwouter.ql.interpreter.components.AFormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

import java.util.HashMap;

public class QLInterpreter {
    private Environment environment;

    public HashMap<String, Object> getEnvVars() {
        return environment.getEnvVars();
    }

    public void resetEnvironment() {
        environment = new Environment();
    }

    public void interprete(Start start) throws InterpretationException{
        new AFormInterpreter().interprete(environment, ((AFormBegin) start.getPBegin()).getForm());
    }

}
