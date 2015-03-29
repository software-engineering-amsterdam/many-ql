package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.types.BooleanValue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PStatementTypeChecker extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PExpressionTypeChecker pExpressionTypeChecker;
    private final Map<String, List<String>> variableDependencies;
    private final TypeCheckResults typeCheckResults;

    private void typeCheckExpressionIsBoolean(PExpression ifExpression) {
        ifExpression.apply(pExpressionTypeChecker);
        pExpressionTypeChecker.checkLastEntryIsOfType(BooleanValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    private void typeCheckIfExpression(AIfStatement node) {
        final PExpression ifExpression = node.getExpression();
        typeCheckExpressionIsBoolean(ifExpression);
    }

    private void typeCheckIfExpression(AIfElseStatement node) {
        final PExpression ifExpression = node.getExpression();
        typeCheckExpressionIsBoolean(ifExpression);
    }

    @Override
    public void caseAIfStatement(final AIfStatement node) {
        typeCheckIfExpression(node);
        typeCheckThenStatements(node);
    }

    private void typeCheckStatement(PStatement node) {
        node.apply(this);
    }

    @Override
    public void caseAIfElseStatement(AIfElseStatement node) {
        typeCheckIfExpression(node);
        typeCheckThenStatements(node);
        typeCheckElseStatements(node);
    }

    private void typeCheckThenStatements(AIfStatement node) {
        for (PStatement thenStatement : node.getThenStatementList()) {
            typeCheckStatement(thenStatement);
        }
    }

    private void typeCheckThenStatements(AIfElseStatement node) {
        for (PStatement thenStatement : node.getThenStatementList()) {
            typeCheckStatement(thenStatement);
        }
    }

    private void typeCheckElseStatements(AIfElseStatement node) {
        for (PStatement elseStatement : node.getElseStatementList()) {
            typeCheckStatement(elseStatement);
        }
    }

    private ITypeDescriptor getTypeOfField(AValueStatement node) {
        String identifier = node.getIdentifier().getText();
        return staticFields.getTypeOfField(identifier);
    }

    private void processExpressionOf(AValueStatement node) {
        final PExpression expression = node.getExpression();
        expression.apply(pExpressionTypeChecker);
    }

    private void checkExpressionIsOfType(AValueStatement node, ITypeDescriptor typeDescriptor) {
        processExpressionOf(node);
        pExpressionTypeChecker.checkLastEntryIsOfType(typeDescriptor);
    }

    private void checkCyclicDependency(String identifier){
        for(String dependency: variableDependencies.get(identifier)){
            if(variableDependencies.get(dependency) != null && variableDependencies.get(dependency).contains(identifier)) {
                typeCheckResults.addCyclicDependencyError(identifier, dependency);
            }
        }
    }

    @Override
    public void caseAValueStatement(AValueStatement node) {
        final ITypeDescriptor typeDescriptor = getTypeOfField(node);
        final String identifier = node.getIdentifier().getText();
        variableDependencies.put(identifier, new LinkedList<String>());
        pExpressionTypeChecker.setLastComputedValueIdentifier(identifier);
        checkExpressionIsOfType(node, typeDescriptor);
        checkCyclicDependency(identifier);
        pExpressionTypeChecker.setLastComputedValueIdentifier(null);
    }

    public PStatementTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.staticFields = staticFields;
        this.typeCheckResults = typeCheckResults;
        variableDependencies = new HashMap<String, List<String>>();
        this.pExpressionTypeChecker = new PExpressionTypeChecker(staticFields, typeCheckResults, variableDependencies);
    }

}
