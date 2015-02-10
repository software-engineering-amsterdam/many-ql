package org.uva.student.calinwouter.ql.interpreter;

import org.uva.student.calinwouter.ql.generated.node.AFormBegin;
import org.uva.student.calinwouter.ql.generated.node.PForm;
import org.uva.student.calinwouter.ql.generated.node.Start;
import org.uva.student.calinwouter.ql.interpreter.components.AFormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;
import org.uva.student.calinwouter.ql.interpreter.model.types.TForm;

import java.util.HashMap;

public class QLInterpreter {
    private AFormInterpreter aFormInterpreter;
    private Start start;
    private Environment environment;

    public TForm interprete() throws InterpretationException{
        aFormInterpreter.interprete(environment, ((AFormBegin) start.getPBegin()).getForm());
    }

    public QLInterpreter(Start start) {
        this.start = start;
        aFormInterpreter = new AFormInterpreter();
        environment = new Environment();
    }

}
