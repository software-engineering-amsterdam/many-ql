package org.uva.student.calinwouter.ql.interpreter.headless;

import org.uva.student.calinwouter.ql.generated.node.AForm;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.StmtInterpreter;

/**
 * The HeadlessFormInterpreter is used for interpreting statements without additional actions. This
 * may be useful for extending or for extracting interpreted data, e.g. expressions.
 */
public class HeadlessFormInterpreter extends FormInterpreter {

    @Override
    protected StmtInterpreter createStmtInterpreter() {
        return new HeadlessStmtInterpreter(this);
    }

    @Override
    public void caseAForm(AForm node) {
        super.caseAForm(node);
        super.reInterpret();
    }
}
