package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui;

import org.uva.student.calinwouter.qlqls.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.qlqls.generated.node.AValueStmt;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.StmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt.ComputedValueInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt.QuestionStmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InterpretationException;

import javax.swing.*;

public class GuiStmtInterpreter extends StmtInterpreter {
    private final JPanel jPanel;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        try {
            new QuestionStmtInterpreter(jPanel, formInterpreter, node).interpret();
        } catch(InterpretationException e) {
            formInterpreter.notifyTypeChecker(e);
        }
    }

    @Override
    public void caseAValueStmt(AValueStmt node) {
        try {
            new ComputedValueInterpreter(jPanel, formInterpreter, node).interpret();
        } catch(InterpretationException e) {
            formInterpreter.notifyTypeChecker(e);
        }
    }

    @Override
    protected StmtInterpreter createStmtInterpreter() {
        return new GuiStmtInterpreter(jPanel, formInterpreter);
    }

    public GuiStmtInterpreter(JPanel jPanel, FormInterpreter formInterpreter) {
        super(formInterpreter);
        this.jPanel = jPanel;
    }
}
