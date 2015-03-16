package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.exceptions.VariableNotSetException;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.Stack;

public class PExpInterpreter extends AnalysisAdapter {
    private VariableTable oldVariableTable, newVariableTable;
    private final Stack<Value> valueStack;

    @Override
    public void caseAAddExp(AAddExp node) {
        pushValue(interpretExpression(node.getLeft()).add(interpretExpression(node.getRight())));
    }

    @Override
    public void caseASubExp(ASubExp node) {
        pushValue(interpretExpression(node.getLeft()).sub(interpretExpression(node.getRight())));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        pushValue(new BoolValue(true));
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        pushValue(new BoolValue(false));
    }

    @Override
    public void caseAOrExp(AOrExp node) {
        pushValue(interpretExpression(node.getLeft()).or(interpretExpression(node.getRight())));
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        pushValue(interpretExpression(node.getLeft()).and(interpretExpression(node.getRight())));
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        pushValue(interpretExpression(node.getLeft()).eq(interpretExpression(node.getRight())));
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        pushValue(interpretExpression(node.getLeft()).neq(interpretExpression(node.getRight())));
    }

    @Override
    public void caseALtExp(ALtExp node) {
        pushValue(interpretExpression(node.getLeft()).lt(interpretExpression(node.getRight())));
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        pushValue(interpretExpression(node.getLeft()).gt(interpretExpression(node.getRight())));
    }

    @Override
    public void caseALteExp(ALteExp node) {
        pushValue(interpretExpression(node.getLeft()).lte(interpretExpression(node.getRight())));
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        pushValue(interpretExpression(node.getLeft()).gte(interpretExpression(node.getRight())));
    }

    @Override
    public void caseAMulExp(AMulExp node) {
        pushValue(interpretExpression(node.getLeft()).mul(interpretExpression(node.getRight())));
    }

    @Override
    public void caseADivExp(ADivExp node) {
        pushValue(interpretExpression(node.getLeft()).div(interpretExpression(node.getRight())));
    }

    @Override
    public void caseAModExp(AModExp node) {
        pushValue(interpretExpression(node.getLeft()).mod(interpretExpression(node.getRight())));
    }

    @Override
    public void caseANotExp(ANotExp node) {
        pushValue(interpretExpression(node.getExp()).not());
    }

    @Override
    public void caseANumberExp(ANumberExp node) {
        pushValue(new IntegerValue(Integer.parseInt(node.getNumber().getText())));
    }

    @Override
    public void caseAIdentExp(AIdentExp node) {
        Value value = (variableTable.getVariable(node.getIdent().getText()));
        if (value == null) {
            throw new VariableNotSetException(node.getIdent().getText());
        }
        pushValue(value);
    }

    public Value popValue() {
        return valueStack.pop();
    }

    private void pushValue(Value value) {
        valueStack.push(value);
    }

    private Value interpretExpression(Node n) {
        n.apply(this);
        return popValue();
    }

    public PExpInterpreter(VariableTable oldVariableTable, VariableTable newVariableTable) {
        super();
        this.oldVariableTable = oldVariableTable;
        this.newVariableTable = newVariableTable;
        this.valueStack = new Stack<Value>();
    }
}