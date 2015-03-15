package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.PTypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTypeTable;

public class PFormTypeChecker extends AnalysisAdapter {
    private PExpTypeChecker pExpTypeChecker;

    @Override
    public void caseAIfStmt(final AIfStmt node) {
        for (Node n : node.getThenStmtList()) {
            n.apply(this);
        }
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        node.getExp().apply(pExpTypeChecker);
        PTypeInterpreter pTypeInterpreter = new PTypeInterpreter();
        node.apply(pTypeInterpreter);
        pExpTypeChecker.checkLastEntryIsOfType(pTypeInterpreter.popValue());
    }

    public PFormTypeChecker(VariableTypeTable variableTypeTable, TypeCheckResults typeCheckResults) {
        this.pExpTypeChecker = new PExpTypeChecker(variableTypeTable, typeCheckResults);
    }
}
