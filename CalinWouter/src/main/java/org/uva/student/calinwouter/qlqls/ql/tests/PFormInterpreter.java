package org.uva.student.calinwouter.qlqls.ql.tests;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStatement;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;

import java.util.List;

public class PFormInterpreter extends AnalysisAdapter {
    private final PStatementInterpreter statementInterpreter;

    @Override
    public void caseAForm(AForm aForm) {
        final List<PStatement> statements = aForm.getStatement();
        for (PStatement statement : statements) {
            statement.apply(statementInterpreter);
        }
    }

    public PFormInterpreter(VariableTable oldVariableTable, VariableTable newVariableTable, StaticFields staticFields) {
        this.statementInterpreter = new PStatementInterpreter(oldVariableTable, newVariableTable, staticFields);
    }
}