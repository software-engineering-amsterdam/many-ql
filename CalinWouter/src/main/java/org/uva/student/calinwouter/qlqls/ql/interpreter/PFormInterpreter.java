package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStmt;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.ResultingFieldsCollection;

import java.util.LinkedList;

public class PFormInterpreter extends AnalysisAdapter {
    private final PStmtInterpreter stmtInterpreter;

    @Override
    public void caseAForm(AForm aForm) {
        final LinkedList<PStmt> stmts = aForm.getStmt();
        for (PStmt stmt : stmts) {
            stmt.apply(stmtInterpreter);
        }
    }

    PFormInterpreter(VariableTable variableTable, ResultingFieldsCollection form) {
        this.stmtInterpreter = new PStmtInterpreter(variableTable, form);
    }
}