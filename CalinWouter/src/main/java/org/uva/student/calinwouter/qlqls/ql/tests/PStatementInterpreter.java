package org.uva.student.calinwouter.qlqls.ql.tests;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.LinkedList;

import static org.uva.student.calinwouter.qlqls.ql.helper.ASTHelper.*;

public class PStatementInterpreter extends AnalysisAdapter {
    private final VariableTable oldVariableTable;
    private final VariableTable newVariableTable;
    private final PExpressionInterpreter expressionInterpreter;
    private final StaticFields staticFields;

    @Override
    public void caseAQuestionStatement(final AQuestionStatement node) {
        final String nodeIdentifier = getIdentifier(node);
        if (wasPreviouslySet(nodeIdentifier)) {
            setNewVariableToOldValue(nodeIdentifier);
            return;
        }
        setNewVariableToDefault(nodeIdentifier);
    }

    @Override
    public void caseAValueStatement(final AValueStatement node) {
        final String nodeIdentifier = getIdentifier(node);
        processExpressionNode(node);
        setNewVariableToPopExpression(nodeIdentifier);
    }

    private boolean wasPreviouslySet(String nodeIdentifier) {
        return oldVariableTable.isSet(nodeIdentifier);
    }

    @Override
    public void caseAIfElseStatement(AIfElseStatement node) {
        processExpressionNode(node);
        if (popExpressionValueIsTrue()) {
            executeStatements(node.getThenStatementList());
            return;
        }
        executeStatements(node.getElseStatementList());
    }

    @Override
    public void caseAIfStatement(AIfStatement node) {
        processExpressionNode(node);
        if (popExpressionValueIsTrue()) {
            executeStatements(node.getThenStatementList());
        }
    }

    private void setNewVariableToOldValue(String nodeIdentifier) {
        final Value variableValue = oldVariableTable.getVariable(nodeIdentifier);
        newVariableTable.setVariable(nodeIdentifier, variableValue);
    }

    private void setNewVariableToDefault(String nodeIdentifier) {
        final ITypeDescriptor valueType = staticFields.getTypeOfField(nodeIdentifier);
        final Value value = valueType.getDefaultValue();
        newVariableTable.setVariable(nodeIdentifier, value);
    }

    private void setNewVariableToPopExpression(String nodeIdentifier) {
        newVariableTable.setVariable(nodeIdentifier, expressionInterpreter.popValue());
    }

    private void executeStatements(LinkedList<PStatement> statementList) {
        for (PStatement s : statementList) {
            s.apply(this);
        }
    }

    private boolean popExpressionValueIsTrue() {
        BooleanValue lastValue = (BooleanValue) expressionInterpreter.popValue();
        return lastValue.isTrue();
    }

    private void processExpressionNode(AIfStatement node) {
        node.getExpression().apply(expressionInterpreter);
    }

    private void processExpressionNode(AValueStatement node) {
        node.getExpression().apply(expressionInterpreter);
    }

    private void processExpressionNode(AIfElseStatement node) {
        node.getExpression().apply(expressionInterpreter);
    }

    public PStatementInterpreter(VariableTable oldVariableTable, VariableTable newVariableTable, StaticFields staticFields) {
        this.expressionInterpreter = new PExpressionInterpreter(newVariableTable);
        this.oldVariableTable = oldVariableTable;
        this.newVariableTable = newVariableTable;
        this.staticFields = staticFields;
    }
}