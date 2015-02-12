package org.uva.student.calinwouter.ql.interpreter.headless;

import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.components.ExpInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.ql.interpreter.components.StmtInterpreter;

public class HeadlessStmtInterpreter extends StmtInterpreter {

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {

    }

    // TODO apply most to the actual interpreter as well.
    @Override
    public void caseAValueStmt(final AValueStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        node.getExp().apply(expInterpreter);
        formInterpreter.setFieldWithoutReinterprete(node.getIdent().getText(),
                expInterpreter.getValue());
    }

    protected StmtInterpreter createStmtInterpreter() {
        return new HeadlessStmtInterpreter(formInterpreter);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        node.getExp().apply(expInterpreter);
        if (expInterpreter.getValue().getValue() == Boolean.TRUE) {
            executeStmtList(node.getThenStmtList());
        } else {
            executeStmtList(node.getElseStmtList());
        }
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        node.getExp().apply(expInterpreter);
        if (expInterpreter.getValue().getValue() == Boolean.TRUE) {
            executeStmtList(node.getThenStmtList());
        }
        executeStmtList(node.getThenStmtList());
    }

    public HeadlessStmtInterpreter(FormInterpreter formInterpreter) {
        super(formInterpreter);
    }

}
