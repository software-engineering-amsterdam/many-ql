package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;

import java.util.LinkedList;

//public class HeadlessStmtInterpreter extends StmtInterpreter {
public class StmtInterpreter extends AnalysisAdapter{
    private final FormInterpreter formInterpreter;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        if (formInterpreter.getField(node.getIdent().getText()) == null) {
            formInterpreter.setField(node.getIdent().getText(),
                    typeInterpreter.getValue().getDefaultValue());
        }
        ((FormInterpreter) formInterpreter).addFormField(new QuestionField(node.getStr().getText(),
                node.getIdent().getText(), typeInterpreter.getValue(), formInterpreter));
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        // TODO it may crash here if not all fields are correcrly set.
        try {
            node.getExp().apply(expInterpreter);
        } catch (Exception e) {
            formInterpreter.setField(node.getIdent().getText(), null);
            return;
        }
        formInterpreter.setField(node.getIdent().getText(),
                expInterpreter.getValue());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);

        ((FormInterpreter) formInterpreter).addFormField(new ComputedValueField(node.getStr().getText(),
                node.getIdent().getText(), typeInterpreter.getValue(), formInterpreter));
    }

    protected StmtInterpreter createStmtInterpreter() {
        return new StmtInterpreter(formInterpreter);
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

    protected void executeStmtList(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(createStmtInterpreter());
        }
    }

    public StmtInterpreter(FormInterpreter formInterpreter) {
        this.formInterpreter = formInterpreter;
       //super(formInterpreter);
    }

}