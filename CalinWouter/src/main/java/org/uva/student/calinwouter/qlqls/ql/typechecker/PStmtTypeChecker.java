package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PStmtTypeChecker extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PExpTypeChecker pExpTypeChecker;
    private final Map<String, List<String>> variableDependencies;
    private final TypeCheckResults typeCheckResults;

    private void typeCheckExpressionIsBoolean(PExp ifExpression) {
        ifExpression.apply(pExpTypeChecker);
        pExpTypeChecker.checkLastEntryIsOfType(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR);
    }

    private void typeCheckIfExpression(AIfStmt node) {
        final PExp ifExpression = node.getExp();
        typeCheckExpressionIsBoolean(ifExpression);
    }

    private void typeCheckIfExpression(AIfelseStmt node) {
        final PExp ifExpression = node.getExp();
        typeCheckExpressionIsBoolean(ifExpression);
    }

    @Override
    public void caseAIfStmt(final AIfStmt node) {
        typeCheckIfExpression(node);
        typeCheckThenStatements(node);
    }

    private void typeCheckStatement(PStmt node) {
        node.apply(this);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        typeCheckIfExpression(node);
        typeCheckThenStatements(node);
        typeCheckElseStatements(node);
    }

    private void typeCheckThenStatements(AIfStmt node) {
        for (PStmt thenStatement : node.getThenStmtList()) {
            typeCheckStatement(thenStatement);
        }
    }

    private void typeCheckThenStatements(AIfelseStmt node) {
        for (PStmt thenStatement : node.getThenStmtList()) {
            typeCheckStatement(thenStatement);
        }
    }

    private void typeCheckElseStatements(AIfelseStmt node) {
        for (PStmt elseStatement : node.getElseStmtList()) {
            typeCheckStatement(elseStatement);
        }
    }

    private ITypeDescriptor getTypeOfField(AValueStmt node) {
        String identifier = node.getIdent().getText();
        return staticFields.getTypeOfField(identifier);
    }

    private void processExpressionOf(AValueStmt node) {
        final PExp expression = node.getExp();
        expression.apply(pExpTypeChecker);
    }

    private void checkExpressionIsOfType(AValueStmt node, ITypeDescriptor typeDescriptor) {
        processExpressionOf(node);
        pExpTypeChecker.checkLastEntryIsOfType(typeDescriptor);
    }

    private void checkCyclicDependency(String identifier){
        for(String dependency: variableDependencies.get(identifier)){
            if(variableDependencies.get(dependency) != null && variableDependencies.get(dependency).contains(identifier))
                typeCheckResults.addCyclicDependencyError(identifier, dependency);
        }
    }

    @Override
    public void caseAValueStmt(AValueStmt node) {
        final ITypeDescriptor typeDescriptor = getTypeOfField(node);
        final String identifier = node.getIdent().getText();
        variableDependencies.put(identifier, new LinkedList<String>());
        pExpTypeChecker.setLastComputedValueIdentifier(identifier);
        checkExpressionIsOfType(node, typeDescriptor);
        checkCyclicDependency(identifier);
        pExpTypeChecker.setLastComputedValueIdentifier(null);
    }

    public PStmtTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.staticFields = staticFields;
        this.typeCheckResults = typeCheckResults;
        variableDependencies = new HashMap<String, List<String>>();
        this.pExpTypeChecker = new PExpTypeChecker(staticFields, typeCheckResults, variableDependencies);
    }

}
