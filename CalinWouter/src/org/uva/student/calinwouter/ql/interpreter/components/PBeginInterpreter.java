package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

public class PBeginInterpreter implements InterpreterInterface<PBegin> {
    @Override
    public Object interprete(Environment e, PBegin node) {
        if (node instanceof AExpBegin) {
            return new PExpIntepreter().interprete(e, ((AExpBegin) node).getExp());
        } else if (node instanceof AFormBegin) {
            return new AFormInterpreter().interprete(e, (AForm) ((AFormBegin) node).getForm());
        }
        throw new RuntimeException("Unexpected Grammar Instance.");
    }
}
