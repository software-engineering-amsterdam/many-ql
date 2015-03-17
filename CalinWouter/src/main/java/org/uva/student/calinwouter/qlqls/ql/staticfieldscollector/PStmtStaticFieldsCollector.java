package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
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
    public void caseAQuestionStmt(final AQuestionStmt node) {
        final TypeDescriptor typeOfValue = getType(node);
        final String label = getLabel(node);
        final String identifier = getIdentifier(node);
        addStaticField(new StaticQuestionField(label, identifier, typeOfValue));
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        final TypeDescriptor typeOfValue = getType(node);
        final String label = getLabel(node);
        final String identifier = getIdentifier(node);
        addStaticField(new StaticComputedValueField(label, identifier, typeOfValue));
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        collectStaticFieldsThenList(node);
        collectStaticFieldsElseList(node);
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        collectStaticFieldsThenList(node);
    }

    private static String getLabel(AValueStmt statement) {
        final TString labelInAst = statement.getStr();
        return labelInAst.getText();
    }

    private static String getIdentifier(AValueStmt statement) {
        final TIdent identifierInAst = statement.getIdent();
        return identifierInAst.getText();
    }

    private TypeDescriptor getType(final AValueStmt node) {
        final PType nodeTypeObject = node.getType();
        nodeTypeObject.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    private static String getLabel(AQuestionStmt statement) {
        final TString labelInAst = statement.getStr();
        return labelInAst.getText();
    }

    private static String getIdentifier(AQuestionStmt statement) {
        final TIdent identifierInAst = statement.getIdent();
        return identifierInAst.getText();
    }

    private TypeDescriptor getType(final AQuestionStmt node) {
        final PType nodeTypeObject = node.getType();
        nodeTypeObject.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    private void collectStaticFieldsThenList(AIfStmt node) {
        for (PStmt pStmt : node.getThenStmtList()) {
            pStmt.apply(this);
        }
    }

    private void collectStaticFieldsThenList(AIfelseStmt node) {
        for (PStmt pStmt : node.getThenStmtList()) {
            pStmt.apply(this);
        }
    }

    private void collectStaticFieldsElseList(AIfelseStmt node) {
        for (PStmt pStmt : node.getElseStmtList()) {
            pStmt.apply(this);
        }
    }

    public PStmtStaticFieldsCollector(StaticFields staticFields) {
        this.staticFields = staticFields;
        this.pTypeCollector = new PTypeCollector();
    }
}
