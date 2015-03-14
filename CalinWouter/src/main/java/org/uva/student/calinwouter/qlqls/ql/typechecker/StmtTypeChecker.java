package org.uva.student.calinwouter.qlqls.ql.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.exceptions.IfNotBoolOrNullException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InvalidComputedValueTypeException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;

import java.util.LinkedList;

//TODO this class still uses the TypeInterpreter class - this must be changed!
public class StmtTypeChecker extends AnalysisAdapter {
    private final FormTypeChecker formTypeChecker;

    // TODO apply most to the actual ql as well.
    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        formTypeChecker.registerFieldUse(node.getIdent().getText());
        formTypeChecker.registerLabelUse(node.getStr().getText());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        formTypeChecker.setTypeDescriptor(node.getIdent().getText(), typeInterpreter.getValue());
        formTypeChecker.setField(node.getIdent().getText(),
                typeInterpreter.getValue().getDefaultValue());
    }

    // TODO apply most to the actual ql as well.
    @Override
    public void caseAValueStmt(final AValueStmt node) {
        formTypeChecker.registerFieldUse(node.getIdent().getText());
        formTypeChecker.registerLabelUse(node.getStr().getText());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        formTypeChecker.setField(node.getIdent().getText(),
                typeInterpreter.getValue().getDefaultValue());

        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formTypeChecker);
        node.getExp().apply(expTypeChecker);

        formTypeChecker.setTypeDescriptor(node.getIdent().getText(), typeInterpreter.getValue());

        if (typeInterpreter.getValue().getDefaultValue().getTypeModelClass()
                != expTypeChecker.getValue().getTypeModelClass()) {

            // TODO outputs actual Java type.
            throw new InvalidComputedValueTypeException(
                    typeInterpreter.getValue().getDefaultValue().getTypeModelClass().toString(),
                    expTypeChecker.getValue().getTypeModelClass().toString());
        }
    }

    protected StmtTypeChecker createStmtInterpreter(){
        return new StmtTypeChecker(formTypeChecker);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formTypeChecker);
        node.getExp().apply(expTypeChecker);
        if (expTypeChecker.getValue() == null || !(expTypeChecker.getValue().getValue() instanceof Boolean)) {
            throw new IfNotBoolOrNullException();
        }
        executeStmtList(node.getThenStmtList());
        executeStmtList(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formTypeChecker);
        node.getExp().apply(expTypeChecker);
        if (expTypeChecker.getValue() == null || !(expTypeChecker.getValue().getValue() instanceof Boolean)) {
            throw new IfNotBoolOrNullException();
        }
        executeStmtList(node.getThenStmtList());
    }

    protected void executeStmtList(LinkedList<PStmt> stmtList) {
        for (PStmt s : stmtList) {
            s.apply(createStmtInterpreter());
        }
    }

    public StmtTypeChecker(FormTypeChecker formTypeChecker) {
        this.formTypeChecker = formTypeChecker;
    }

}