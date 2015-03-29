package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractStaticFormField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;

public class PStmtStaticFieldsCollector extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PTypeCollector pTypeCollector;

    private void addStaticField(AbstractStaticFormField abstractStaticFormField) {
        staticFields.addStaticField(abstractStaticFormField);
    }

    @Override
    public void caseAQuestionStatement(final AQuestionStatement node) {
        final ITypeDescriptor typeOfValue = getType(node);
        final String label = getLabel(node);
        final String identifier = getIdentifier(node);
        addStaticField(new StaticQuestionField(label, identifier, typeOfValue));
    }

    @Override
    public void caseAValueStatement(final AValueStatement node) {
        final ITypeDescriptor typeOfValue = getType(node);
        final String label = getLabel(node);
        final String identifier = getIdentifier(node);
        addStaticField(new StaticComputedValueField(label, identifier, typeOfValue));
    }

    @Override
    public void caseAIfElseStatement(AIfElseStatement node) {
        collectStaticFieldsThenList(node);
        collectStaticFieldsElseList(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node) {
        collectStaticFieldsThenList(node);
    }

    private static String getLabel(AValueStatement statement) {
        final TString labelInAst = statement.getString();
        return labelInAst.getText();
    }

    private static String getIdentifier(AValueStatement statement) {
        final TIdentifier identifierInAst = statement.getIdentifier();
        return identifierInAst.getText();
    }

    private ITypeDescriptor getType(final AValueStatement node) {
        final PType nodeTypeObject = node.getType();
        nodeTypeObject.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    private static String getLabel(AQuestionStatement statement) {
        final TString labelInAst = statement.getString();
        return labelInAst.getText();
    }

    private static String getIdentifier(AQuestionStatement statement) {
        final TIdentifier identifierInAst = statement.getIdentifier();
        return identifierInAst.getText();
    }

    private ITypeDescriptor getType(final AQuestionStatement node) {
        final PType nodeTypeObject = node.getType();
        nodeTypeObject.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    private void collectStaticFieldsThenList(AIfStatement node) {
        for (PStatement pStmt : node.getThenStatementList()) {
            pStmt.apply(this);
        }
    }

    private void collectStaticFieldsThenList(AIfElseStatement node) {
        for (PStatement pStmt : node.getThenStatementList()) {
            pStmt.apply(this);
        }
    }

    private void collectStaticFieldsElseList(AIfElseStatement node) {
        for (PStatement pStmt : node.getElseStatementList()) {
            pStmt.apply(this);
        }
    }

    public PStmtStaticFieldsCollector(StaticFields staticFields) {
        this.staticFields = staticFields;
        this.pTypeCollector = new PTypeCollector();
    }
}
