package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.DepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.QLTypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;

public class PFormTypeChecker extends DepthFirstAdapter {
    private final PStatementTypeChecker pStatementTypeChecker;

    private void typeCheckForm(AForm form) {
        for(PStatement pStatement: form.getStatement()) {
            pStatement.apply(pStatementTypeChecker);
        }
    }

    @Override
    public void caseAForm(AForm node) {
        typeCheckForm(node);
    }

    public PFormTypeChecker(StaticFields staticFields, QLTypeCheckResults QLTypeCheckResults) {
        this.pStatementTypeChecker = new PStatementTypeChecker(staticFields, QLTypeCheckResults);
    }
}
