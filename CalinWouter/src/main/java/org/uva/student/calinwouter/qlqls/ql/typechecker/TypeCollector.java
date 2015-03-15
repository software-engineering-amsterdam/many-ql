package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.model.VariableTypeTable;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;

public class TypeCollector extends AnalysisAdapter {
    private final VariableTypeTable variableTypeTable;
    private String currentIdentifier;

    @Override
    public void caseAIntType(final AIntType node) {
        assert(currentIdentifier != null);
        variableTypeTable.setVariableType(currentIdentifier, IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
        currentIdentifier = null;
    }

    @Override
    public void caseAStringType(final AStringType node) {
        assert(currentIdentifier != null);
        variableTypeTable.setVariableType(currentIdentifier, IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
        currentIdentifier = null;
    }

    @Override
    public void caseABoolType(final ABoolType node) {
        assert(currentIdentifier != null);
        variableTypeTable.setVariableType(currentIdentifier, IntegerValue.INTEGER_VALUE_TYPE_DESCRIPTOR);
        currentIdentifier = null;
    }

    @Override
    public void caseAIfelseStmt(final AIfelseStmt node) {
        for (Node n : node.getThenStmtList()) {
            n.apply(this);
        }
        for (Node n : node.getElseStmtList()) {
            n.apply(this);
        }
    }

    @Override
    public void caseAIfStmt(final AIfStmt node) {
        for (Node n : node.getThenStmtList()) {
            n.apply(this);
        }
    }

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        currentIdentifier = node.getIdent().getText();
        node.getType().apply(this);
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        currentIdentifier = node.getIdent().getText();
        node.getType().apply(this);
    }

    @Override
    public void caseAForm(final AForm node) {
        for (PStmt stmt : node.getStmt()) {
            stmt.apply(this);
        }
    }

    public TypeCollector(VariableTypeTable variableTypeTable) {
        this.variableTypeTable = variableTypeTable;
    }
}
