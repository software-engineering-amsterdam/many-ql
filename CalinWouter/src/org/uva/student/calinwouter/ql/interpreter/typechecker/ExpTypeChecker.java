package org.uva.student.calinwouter.ql.interpreter.typechecker;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.components.ExpInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.types.TInteger;

public class ExpTypeChecker extends ExpInterpreter {

    @Override
    public void caseANumberExp(ANumberExp node) {
        setValue(new TInteger(null));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        setValue(new TBool(true));
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        setValue(new TBool(false));
    }

    public ExpTypeChecker(FormInterpreter formInterpreter) {
        super(formInterpreter);
    }

}
