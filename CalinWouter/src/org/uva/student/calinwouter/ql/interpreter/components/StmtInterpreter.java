package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.components.stmt.ComputedValueInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.stmt.QuestionStmtInterpreter;
import org.uva.student.calinwouter.ql.interpreter.exceptions.InterpretationException;
import org.uva.student.calinwouter.ql.interpreter.exceptions.NotOfTypeException;

import javax.swing.*;
import java.util.LinkedList;

public abstract class StmtInterpreter extends AnalysisAdapter {
    protected final FormInterpreter formInterpreter;

    @Override
    public abstract void caseAQuestionStmt(final AQuestionStmt node);

    @Override
    public abstract void caseAValueStmt(final AValueStmt node);

    private boolean testBoolean(PExp nExp) {
        ExpInterpreter expI = new ExpInterpreter(formInterpreter);
        nExp.apply(expI);
        if (!(expI.getValue().getValue() instanceof Boolean)) {
            throw new NotOfTypeException("Boolean");
        } else if ((Boolean) expI.getValue().getValue()) {
            return true;
        }
        return false;
    }

    protected abstract StmtInterpreter createStmtInterpreter();

    protected void executeStmtList(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(createStmtInterpreter());
        }
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        try {
            if (testBoolean(node.getExp())) {
                executeStmtList(node.getThenStmtList());
            } else {
                executeStmtList(node.getElseStmtList());
            }
        } catch(InterpretationException e) {
            formInterpreter.notifyTypeChecker(e);
        }
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        try {
            if (testBoolean(node.getExp())) {
                executeStmtList(node.getThenStmtList());
            }
        } catch(InterpretationException e) {
            formInterpreter.notifyTypeChecker(e);
        }
    }

    public StmtInterpreter(FormInterpreter formInterpreter) {
        this.formInterpreter = formInterpreter;
    }

}