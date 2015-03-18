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
    private final VariableTable newVariableTable;
    private final Stack<Value> valueStack;

    @Override
    public void caseAAddExp(AAddExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.add(rightValue);
        pushValue(result);
    }

    @Override
    public void caseASubExp(ASubExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.sub(rightValue);
        pushValue(result);
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        final BoolValue trueValue = new BoolValue(true);
        pushValue(trueValue);
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        final BoolValue falseValue = new BoolValue(false);
        pushValue(falseValue);
    }

    @Override
    public void caseAOrExp(AOrExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.or(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.and(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.eq(rightValue);
        pushValue(result);
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.neq(rightValue);
        pushValue(result);
    }

    @Override
    public void caseALtExp(ALtExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.lt(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.gt(rightValue);
        pushValue(result);
    }

    @Override
    public void caseALteExp(ALteExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.lte(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.gte(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAMulExp(AMulExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.mul(rightValue);
        pushValue(result);
    }

    @Override
    public void caseADivExp(ADivExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.div(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAModExp(AModExp node) {
        final PExp leftNode = node.getLeft();
        final PExp rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.mod(rightValue);
        pushValue(result);
    }

    @Override
    public void caseANotExp(ANotExp node) {
        final PExp nodeExpression = node.getExp();
        final Value nodeValue = interpretExpression(nodeExpression);
        final Value notNodeValue = nodeValue.not();
        pushValue(notNodeValue);
    }

    @Override
    public void caseANumberExp(ANumberExp node) {
        final TNumber nodeExpAsNumber = node.getNumber();
        final String nodeExpAsString = nodeExpAsNumber.getText();
        final Integer nodeExpAsInteger = Integer.parseInt(nodeExpAsString);
        final IntegerValue integerValue = new IntegerValue(nodeExpAsInteger);
        pushValue(integerValue);
    }

    @Override
    public void caseAIdentExp(AIdentExp node) {
        final String nodeIdentifier = getNodeIdentifier(node);
        if (isNewVariableSet(nodeIdentifier)) {
            final Value value = getVariableValueFromNewTable(nodeIdentifier);
            pushValue(value);
            return;
        }
        throw new VariableNotSetException(nodeIdentifier);
    }

    private Value getVariableValueFromNewTable(String nodeIdentifier) {
        return newVariableTable.getVariable(nodeIdentifier);
    }

    private boolean isNewVariableSet(String nodeIdentifier) {
        return newVariableTable.isSet(nodeIdentifier);
    }

    private String getNodeIdentifier(AIdentExp node) {
        final TIdent ident = node.getIdent();
        return ident.getText();
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

    public PExpInterpreter(VariableTable newVariableTable) {
        super();
        this.newVariableTable = newVariableTable;
        this.valueStack = new Stack<Value>();
    }
}