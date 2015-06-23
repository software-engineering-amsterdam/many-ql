package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interfaces.ITypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.AbstractStaticFormField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticComputedValueField;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.StaticQuestionField;

import static org.uva.student.calinwouter.qlqls.ql.helper.ASTHelper.*;

public class PStatementStaticFieldsCollector extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PTypeCollector pTypeCollector;

    private void addStaticField(AbstractStaticFormField abstractStaticFormField) {
        staticFields.addStaticField(abstractStaticFormField);
    }

    @Override
    public void caseAQuestionStatement(final AQuestionStatement node) {
        final ITypeDescriptor typeOfValue = getType(node);
        final String label = getString(node);
        final String identifier = getIdentifier(node);
        addStaticField(new StaticQuestionField(label, identifier, typeOfValue));
    }

    @Override
    public void caseAValueStatement(final AValueStatement node) {
        final ITypeDescriptor typeOfValue = getType(node);
        final String label = getString(node);
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

    private ITypeDescriptor getType(final AValueStatement node) {
        final PType nodeTypeObject = node.getType();
        nodeTypeObject.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    private ITypeDescriptor getType(final AQuestionStatement node) {
        final PType nodeTypeObject = node.getType();
        nodeTypeObject.apply(pTypeCollector);
        return pTypeCollector.popType();
    }

    private void collectStaticFieldsThenList(AIfStatement node) {
        for (PStatement pStatement : node.getThenStatementList()) {
            pStatement.apply(this);
        }
    }

    private void collectStaticFieldsThenList(AIfElseStatement node) {
        for (PStatement pStatement : node.getThenStatementList()) {
            pStatement.apply(this);
        }
    }

    private void collectStaticFieldsElseList(AIfElseStatement node) {
        for (PStatement pStatement : node.getElseStatementList()) {
            pStatement.apply(this);
        }
    }

    public PStatementStaticFieldsCollector(StaticFields staticFields) {
        this.staticFields = staticFields;
        this.pTypeCollector = new PTypeCollector();
    }
}
