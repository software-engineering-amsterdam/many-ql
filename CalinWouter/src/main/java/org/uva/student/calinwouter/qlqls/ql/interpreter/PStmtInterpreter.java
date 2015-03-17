package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.LinkedList;

public class PStmtInterpreter extends AnalysisAdapter {
    private final VariableTable oldVariableTable;
    private final VariableTable newVariableTable;
    private final PExpInterpreter expInterpreter;
    private final StaticFields staticFields;

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        final String nodeIdentifier = getNodeIdentifier(node);
        if (wasPreviouslySet(nodeIdentifier)) {
            setNewVariableToOldValue(nodeIdentifier);
            return;
        }
        setNewVariableToDefault(nodeIdentifier);
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        final String nodeIdentifier = getNodeIdentifier(node);
        processExpressionNode(node);
        setNewVariableToPopExpression(nodeIdentifier);
    }

    private boolean wasPreviouslySet(String nodeIdentifier) {
        return oldVariableTable.isSet(nodeIdentifier);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        processExpressionNode(node);
        if (popExpressionValueIsTrue()) {
            executeStatements(node.getThenStmtList());
            return;
        }
        executeStatements(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        processExpressionNode(node);
        if (popExpressionValueIsTrue()) {
            executeStatements(node.getThenStmtList());
        }
    }

    private void setNewVariableToOldValue(String nodeIdentifier) {
        final Value variableValue = oldVariableTable.getVariable(nodeIdentifier);
        newVariableTable.setVariable(nodeIdentifier, variableValue);
    }

    private void setNewVariableToDefault(String nodeIdentifier) {
        final Value value = staticFields.getTypeOfField(nodeIdentifier).getDefaultValue();
        newVariableTable.setVariable(nodeIdentifier, value);
    }

    private void setNewVariableToPopExpression(String nodeIdentifier) {
        newVariableTable.setVariable(nodeIdentifier, expInterpreter.popValue());
    }

    private String getNodeIdentifier(AValueStmt node) {
        return node.getIdent().getText();
    }

    private String getNodeIdentifier(AQuestionStmt node) {
        return node.getIdent().getText();
    }

    private void executeStatements(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(this);
        }
    }

    private boolean popExpressionValueIsTrue() {
        BoolValue lastValue = (BoolValue) expInterpreter.popValue();
        return lastValue.isTrue();
    }

    private void processExpressionNode(AIfStmt node) {
        node.getExp().apply(expInterpreter);
    }

    private void processExpressionNode(AValueStmt node) {
        node.getExp().apply(expInterpreter);
    }

    private void processExpressionNode(AIfelseStmt node) {
        node.getExp().apply(expInterpreter);
    }

    public PStmtInterpreter(VariableTable oldVariableTable, VariableTable newVariableTable, StaticFields staticFields) {
        this.expInterpreter = new PExpInterpreter(newVariableTable);
        this.oldVariableTable = oldVariableTable;
        this.newVariableTable = newVariableTable;
        this.staticFields = staticFields;
    }
}