package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.node.Node;
import org.uva.student.calinwouter.ql.generated.node.PExp;
import org.uva.student.calinwouter.ql.interpreter.interfaces.InterpreterInterface;
import org.uva.student.calinwouter.ql.interpreter.model.Environment;

/**
 * Created by calin on 2/9/15.
 */
public class PExpIntepreter implements InterpreterInterface<PExp> {
    private Object expValue;

    public Object getExpValue() { return expValue; }

    @Override
    public void interprete(Environment e, PExp node) {
        System.out.println();
        expValue = true;
    }
}
