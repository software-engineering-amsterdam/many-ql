package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker;

import org.uva.student.calinwouter.qlqls.generated.node.AFalseExp;
import org.uva.student.calinwouter.qlqls.generated.node.ANumberExp;
import org.uva.student.calinwouter.qlqls.generated.node.ATrueExp;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ExpInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

public class ExpTypeChecker extends ExpInterpreter {

    @Override
    public void caseANumberExp(ANumberExp node) {
        setValue(new IntegerValue(null));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        setValue(new BoolValue(null));
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        setValue(new BoolValue(null));
    }

    public ExpTypeChecker(FormInterpreter formInterpreter) {
        super(formInterpreter);
    }

}