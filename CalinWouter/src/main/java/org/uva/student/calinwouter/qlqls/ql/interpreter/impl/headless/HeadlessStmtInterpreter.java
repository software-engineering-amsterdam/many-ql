package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless;

import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessExpInterpreter;
import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;

import java.util.LinkedList;

//public class HeadlessStmtInterpreter extends StmtInterpreter {
public class HeadlessStmtInterpreter extends AnalysisAdapter{
    private final HeadlessFormInterpreter formInterpreter;

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
        HeadlessExpInterpreter headlessExpInterpreter = new HeadlessExpInterpreter(formInterpreter);
        // TODO it may crash here if not all fields are correcrly set.
        try {
            node.getExp().apply(headlessExpInterpreter);
        } catch (Exception e) {
            formInterpreter.setField(node.getIdent().getText(), null);
            return;
        }
        formInterpreter.setField(node.getIdent().getText(),
                headlessExpInterpreter.getValue());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);

        ((HeadlessFormInterpreter) formInterpreter).addFormField(new ComputedValueField(node.getStr().getText(),
                node.getIdent().getText(), typeInterpreter.getValue(), formInterpreter));
    }

    protected HeadlessStmtInterpreter createStmtInterpreter() {
        return new HeadlessStmtInterpreter(formInterpreter);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        HeadlessExpInterpreter headlessExpInterpreter = new HeadlessExpInterpreter(formInterpreter);
        node.getExp().apply(headlessExpInterpreter);
        if (headlessExpInterpreter.getValue().getValue() == Boolean.TRUE) {
            executeStmtList(node.getThenStmtList());
        } else {
            executeStmtList(node.getElseStmtList());
        }
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        HeadlessExpInterpreter headlessExpInterpreter = new HeadlessExpInterpreter(formInterpreter);
        node.getExp().apply(headlessExpInterpreter);
        if (headlessExpInterpreter.getValue().getValue() == Boolean.TRUE) {
            executeStmtList(node.getThenStmtList());
            return;
        }
    }

    protected void executeStmtList(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(createStmtInterpreter());
        }
    }

    public HeadlessStmtInterpreter(HeadlessFormInterpreter formInterpreter) {
        this.formInterpreter = formInterpreter;
       //super(formInterpreter);
    }

}