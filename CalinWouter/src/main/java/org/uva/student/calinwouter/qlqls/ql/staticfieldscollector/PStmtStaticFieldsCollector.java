package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
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
        node.getType().apply(pTypeCollector);
        addStaticField(new StaticQuestionField(
                node.getStr().getText(),
                node.getIdent().getText(),
                pTypeCollector.popType()));
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        node.getType().apply(pTypeCollector);
        addStaticField(new StaticComputedValueField(node.getStr().getText(),
                node.getIdent().getText(),
                pTypeCollector.popType()));
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        for (PStmt pStmt : node.getThenStmtList()) {
            pStmt.apply(this);
        }
        for (PStmt pStmt : node.getElseStmtList()) {
            pStmt.apply(this);
        }
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        for (PStmt pStmt : node.getThenStmtList()) {
            pStmt.apply(this);
        }
    }

    public PStmtStaticFieldsCollector(StaticFields staticFields) {
        this.staticFields = staticFields;
        this.pTypeCollector = new PTypeCollector();
    }
}
