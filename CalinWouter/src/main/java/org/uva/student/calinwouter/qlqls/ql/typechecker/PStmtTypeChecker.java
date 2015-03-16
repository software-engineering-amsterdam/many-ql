package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.AIfStmt;
import org.uva.student.calinwouter.qlqls.generated.node.AIfelseStmt;
import org.uva.student.calinwouter.qlqls.generated.node.AValueStmt;
import org.uva.student.calinwouter.qlqls.generated.node.Node;
import org.uva.student.calinwouter.qlqls.ql.interfaces.TypeDescriptor;
import org.uva.student.calinwouter.qlqls.ql.model.StaticFields;
import org.uva.student.calinwouter.qlqls.ql.model.TypeCheckResults;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;

public class PStmtTypeChecker extends AnalysisAdapter {
    private final StaticFields staticFields;
    private final PExpTypeChecker pExpTypeChecker;
    private final TypeCheckResults typeCheckResults;

    @Override
    public void caseAIfStmt(final AIfStmt node) {
        node.getExp().apply(pExpTypeChecker);
        for (Node n : node.getThenStmtList()) {
            n.apply(this);
        }
        if (!pExpTypeChecker.popType().equals(BoolValue.BOOL_VALUE_TYPE_DESCRIPTOR)) {
            typeCheckResults.addError(node + " Not of type boolean.");
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
        this.typeCheckResults = typeCheckResults;
        this.pExpTypeChecker = new PExpTypeChecker(staticFields, typeCheckResults);
    }

}
