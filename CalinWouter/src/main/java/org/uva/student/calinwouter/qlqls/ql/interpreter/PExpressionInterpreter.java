package org.uva.student.calinwouter.qlqls.ql.interpreter;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTable;
import org.uva.student.calinwouter.qlqls.ql.exceptions.VariableNotSetException;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

import java.util.Stack;

public class PExpressionInterpreter extends AnalysisAdapter {
    private final VariableTable newVariableTable;
    private final Stack<Value> valueStack;

    @Override
    public void caseAAddExpression(AAddExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.add(rightValue);
        pushValue(result);
    }

    @Override
    public void caseASubtractExpression(ASubtractExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.subtract(rightValue);
        pushValue(result);
    }

    @Override
    public void caseATrueExpression(ATrueExpression node) {
        final BooleanValue trueValue = new BooleanValue(true);
        pushValue(trueValue);
    }

    @Override
    public void caseAFalseExpression(AFalseExpression node) {
        final BooleanValue falseValue = new BooleanValue(false);
        pushValue(falseValue);
    }

    @Override
    public void caseAOrExpression(AOrExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.or(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAAndExpression(AAndExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.and(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAEqualsExpression(AEqualsExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.valueEquals(rightValue);
        pushValue(result);
    }

    @Override
    public void caseANotEqualsExpression(ANotEqualsExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.valueNotEquals(rightValue);
        pushValue(result);
    }

    @Override
    public void caseALesserThanExpression(ALesserThanExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.lesserThan(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAGreaterThanExpression(AGreaterThanExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.greaterThan(rightValue);
        pushValue(result);
    }

    @Override
    public void caseALesserThanOrEqualsExpression(ALesserThanOrEqualsExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.lesserThanOrEquals(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAGreaterThanOrEqualsExpression(AGreaterThanOrEqualsExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.greaterThanOrEquals(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAMultiplyExpression(AMultiplyExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.multiply(rightValue);
        pushValue(result);
    }

    @Override
    public void caseADivideExpression(ADivideExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.divide(rightValue);
        pushValue(result);
    }

    @Override
    public void caseAModuloExpression(AModuloExpression node) {
        final PExpression leftNode = node.getLeft();
        final PExpression rightNode = node.getRight();
        final Value leftValue = interpretExpression(leftNode);
        final Value rightValue = interpretExpression(rightNode);
        final Value result = leftValue.modulo(rightValue);
        pushValue(result);
    }

    @Override
    public void caseANotExpression(ANotExpression node) {
        final PExpression nodeExpression = node.getExpression();
        final Value nodeValue = interpretExpression(nodeExpression);
        final Value notNodeValue = nodeValue.not();
        pushValue(notNodeValue);
    }

    @Override
    public void caseANumberExpression(ANumberExpression node) {
        final TNumber nodeExpAsNumber = node.getNumber();
        final String nodeExpAsString = nodeExpAsNumber.getText();
        final Integer nodeExpAsInteger = Integer.parseInt(nodeExpAsString);
        final IntegerValue integerValue = new IntegerValue(nodeExpAsInteger);
        pushValue(integerValue);
    }

    @Override
    public void caseAIdentifierExpression(AIdentifierExpression node) {
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

    private String getNodeIdentifier(AIdentifierExpression node) {
        final TIdentifier ident = node.getIdentifier();
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

    public PExpressionInterpreter(VariableTable newVariableTable) {
        super();
        this.newVariableTable = newVariableTable;
        this.valueStack = new Stack<Value>();
    }
}