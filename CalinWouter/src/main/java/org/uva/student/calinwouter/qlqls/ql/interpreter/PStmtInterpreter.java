package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

import java.util.LinkedList;

public class PStmtInterpreter extends AnalysisAdapter {
    private final VariableTable oldVariableTable, newVariableTable;
    private final PExpInterpreter expInterpreter;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        PTypeInterpreter typeInterpreter = new PTypeInterpreter();
        node.getType().apply(typeInterpreter);
        variableTable.setIfNotSet(node.getIdent().getText(), typeInterpreter.popValue().getDefaultValue());
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        PTypeInterpreter typeInterpreter = new PTypeInterpreter();
        node.getExp().apply(expInterpreter);
        variableTable.setVariable(node.getIdent().getText(), expInterpreter.popValue());
        node.getType().apply(typeInterpreter);
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

    private void executeStatements(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(this);
        }
    }

    public PStmtInterpreter(VariableTable oldVariableTable, VariableTable newVariableTable) {
        this.expInterpreter = new PExpInterpreter(oldVariableTable, newVariableTable);
        this.oldVariableTable = oldVariableTable;
        this.newVariableTable = newVariableTable;
    }
}