package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.StmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;

public class HeadlessStmtInterpreter extends StmtInterpreter {

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        if (formInterpreter.getField(node.getIdent().getText()) == null) {
            formInterpreter.setField(node.getIdent().getText(),
                    typeInterpreter.getValue().getDefaultValue());
        }
        ((HeadlessFormInterpreter) formInterpreter).addFormField(new QuestionField(node.getStr().getText(),
                node.getIdent().getText(), typeInterpreter.getValue(), formInterpreter));
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        // TODO it may crash here if not all fields are correcrly set.
        try {
            node.getExp().apply(expInterpreter);
        } catch(Exception e) {
            formInterpreter.setField(node.getIdent().getText(), null);
            return;
        }
        formInterpreter.setField(node.getIdent().getText(),
                expInterpreter.getValue());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
            node.getType().apply(typeInterpreter);

        ((HeadlessFormInterpreter) formInterpreter).addFormField(new ComputedValueField(node.getStr().getText(),
                node.getIdent().getText(), typeInterpreter.getValue(), formInterpreter));
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
            return;
        }
    }

    public HeadlessStmtInterpreter(FormInterpreter formInterpreter) {
        super(formInterpreter);
    }

}
