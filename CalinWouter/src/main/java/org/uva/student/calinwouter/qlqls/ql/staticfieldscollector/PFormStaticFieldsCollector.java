package org.uva.student.calinwouter.qlqls.ql.staticfieldscollector;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AForm;
import org.uva.student.calinwouter.qlqls.generated.node.PStatement;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;

public class PFormStaticFieldsCollector extends AnalysisAdapter {
    private final PStatementStaticFieldsCollector pStatementStaticFieldsCollector;

    @Override
    public void caseAForm(final AForm node) {
        for (PStatement stmt : node.getStatement()) {
            stmt.apply(pStatementStaticFieldsCollector);
        }
    }

    public PFormStaticFieldsCollector(StaticFields staticFields) {
        this.pStatementStaticFieldsCollector = new PStatementStaticFieldsCollector(staticFields);
    }
}
