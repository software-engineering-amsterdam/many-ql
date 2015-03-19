package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.DepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;

public class PFormTypeChecker extends DepthFirstAdapter {
    private final PStmtTypeChecker pStmtTypeChecker;

    private void typeCheckForm(AForm form) {
        for(PStmt stmt: form.getStmt())
            stmt.apply(pStmtTypeChecker);
    }

    @Override
    public void caseAForm(AForm node) {
        typeCheckForm(node);
    }

    public PFormTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.pStmtTypeChecker = new PStmtTypeChecker(staticFields, typeCheckResults);
    }
}
