package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AIfStmt;
import org.uva.student.calinwouter.qlqls.generated.node.AIfelseStmt;
import org.uva.student.calinwouter.qlqls.generated.node.AValueStmt;
import org.uva.student.calinwouter.qlqls.generated.node.Node;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;

public class PStmtTypeChecker extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PExpTypeChecker pExpTypeChecker;

    @Override
    public void caseAIfStmt(final AIfStmt node) {
        for (Node n : node.getThenStmtList()) {
            n.apply(this);
        }
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        for (Node n : node.getThenStmtList()) {
            n.apply(this);
        }
        for (Node n : node.getElseStmtList()) {
            n.apply(this);
        }
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        node.getExp().apply(pExpTypeChecker);
        TypeDescriptor typeDescriptor = staticFields.getTypeOfField(node.getIdent().getText());
        pExpTypeChecker.checkLastEntryIsOfType(typeDescriptor);
    }

    public PStmtTypeChecker(StaticFields staticFields, TypeCheckResults typeCheckResults) {
        this.staticFields = staticFields;
        this.pExpTypeChecker = new PExpTypeChecker(staticFields, typeCheckResults);
    }

}
