package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.model.ResultingFieldsCollection;
import org.uva.student.calinwouter.qlqls.ql.model.ComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.QuestionField;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

import java.util.LinkedList;

public class PStmtInterpreter extends AnalysisAdapter {
    private final VariableTable variableTable;
    private final ResultingFieldsCollection form;
    private final PExpInterpreter expInterpreter;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        PTypeInterpreter typeInterpreter = new PTypeInterpreter();
        node.getType().apply(typeInterpreter);
        variableTable.setIfNotSet(node.getIdent().getText(), typeInterpreter.popValue().getDefaultValue());
        form.addFormField(new QuestionField(node.getStr().getText(), node.getIdent().getText()));
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        PTypeInterpreter typeInterpreter = new PTypeInterpreter();
        node.getExp().apply(expInterpreter);
        variableTable.setVariable(node.getIdent().getText(), expInterpreter.popValue());
        node.getType().apply(typeInterpreter);
        form.addFormField(new ComputedValueField(node.getStr().getText(), node.getIdent().getText()));
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        node.getExp().apply(expInterpreter);
        if (((BoolValue) expInterpreter.popValue()).isTrue()) {
            executeStatements(node.getThenStmtList());
            return;
        }
        executeStatements(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        node.getExp().apply(expInterpreter);
        if (expInterpreter.popValue().getValue() == Boolean.TRUE) {
            executeStatements(node.getThenStmtList());
        }
    }

    public PStmtInterpreter createStmtInterpreter() {
        return new PStmtInterpreter(variableTable, form);
    }

    private void executeStatements(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(createStmtInterpreter());
        }
    }

    public PStmtInterpreter(VariableTable variableTable, ResultingFieldsCollection form) {
        this.expInterpreter = new PExpInterpreter(variableTable);
        this.variableTable = variableTable;
        this.form = form;
    }
}