package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.DepthFirstAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;

public class PFormTypeChecker extends DepthFirstAdapter {
    private PStmtTypeChecker pStmtTypeChecker;

    @Override
    public void caseAForm(AForm node) {
        node.apply(pStmtTypeChecker);
    }

    public PFormTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.pStmtTypeChecker = new PStmtTypeChecker(staticFields, typeCheckResults);
    }
}
