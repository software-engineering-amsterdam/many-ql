package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker;

import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ExpInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.TBool;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;

public class ExpTypeChecker extends ExpInterpreter {

    @Override
    public void caseANumberExp(ANumberExp node) {
        setValue(new TInteger(null));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        setValue(new TBool(null));
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        setValue(new TBool(null));
    }

    public ExpTypeChecker(FormInterpreter formInterpreter) {
        super(formInterpreter);
    }

}
