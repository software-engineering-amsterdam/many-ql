package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.components.stmt.ComputedValueInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.stmt.QuestionStmtInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.components.types.TypeModel;

import javax.swing.*;
import java.util.Map;

public class StmtInterpreter extends AnalysisAdapter {
    private JPanel jPanel;
    private FormInterpreter formInterpreter;

    private void update(String ident, TypeModel<?> value) {
        formInterpreter.setField(ident, value);
    }

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        new QuestionStmtInterpreter(jPanel, formInterpreter, node).interprete();
    }

    @Override
    public void caseAValueStmt(AValueStmt node) {
        new ComputedValueInterpreter(jPanel, formInterpreter, node).interprete();
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        try {
            ExpInterpreter exp = new ExpInterpreter(formInterpreter);
            node.getExp().apply(exp);
            if (exp.getValue().equals(new TBool(true))) {
                for (PStmt s : node.getThenStmtList()) {
                    s.apply(new StmtInterpreter(jPanel, formInterpreter));
                }
            } else if (exp.getValue().equals(new TBool(false))) {
                for (PStmt s : node.getElseStmtList()) {
                    s.apply(new StmtInterpreter(jPanel, formInterpreter));
                }
            }
        } catch(InterpretationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        try {
            ExpInterpreter exp = new ExpInterpreter(formInterpreter);
            node.getExp().apply(exp);
            if (exp.getValue().equals(new TBool(true))) {
                for (PStmt s : node.getThenStmtList()) {
                    s.apply(new StmtInterpreter(jPanel, formInterpreter));
                }
            }
        } catch(InterpretationException e) {
            e.printStackTrace();
        }
    }

    public StmtInterpreter(JPanel jPanel, FormInterpreter formInterpreter) {
        this.jPanel = jPanel;
        this.formInterpreter = formInterpreter;
    }

}
