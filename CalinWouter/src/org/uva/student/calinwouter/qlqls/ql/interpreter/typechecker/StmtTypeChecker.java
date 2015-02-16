package org.uva.student.calinwouter.qlqls.ql.interpreter.typechecker;

import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.StmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.components.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.exceptions.IfNotBoolOrNull;
import org.uva.student.calinwouter.qlqls.ql.interpreter.exceptions.InvalidComputedValueType;

public class StmtTypeChecker extends StmtInterpreter {

    // TODO apply most to the actual interpreter as well.
    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        formInterpreter.registerFieldUse(node.getIdent().getText());
        formInterpreter.registerLabelUse(node.getStr().getText());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        formInterpreter.setFieldWithoutReinterprete(node.getIdent().getText(),
                typeInterpreter.getValue().getDefaultValue());
    }

    // TODO apply most to the actual interpreter as well.
    @Override
    public void caseAValueStmt(final AValueStmt node) {
        formInterpreter.registerFieldUse(node.getIdent().getText());
        formInterpreter.registerLabelUse(node.getStr().getText());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        formInterpreter.setFieldWithoutReinterprete(node.getIdent().getText(),
                typeInterpreter.getValue().getDefaultValue());

        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
        node.getExp().apply(expTypeChecker);

        if (typeInterpreter.getValue().getDefaultValue().getTypeModelClass()
                != expTypeChecker.getValue().getTypeModelClass()) {

            // TODO outputs actual Java type.
            throw new InvalidComputedValueType(
                    typeInterpreter.getValue().getDefaultValue().getTypeModelClass().toString(),
                    expTypeChecker.getValue().getTypeModelClass().toString());
        }
    }

    protected StmtInterpreter createStmtInterpreter() {
        return new StmtTypeChecker(formInterpreter);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
        node.getExp().apply(expTypeChecker);
        if (expTypeChecker.getValue() == null || !(expTypeChecker.getValue().getValue() instanceof Boolean)) {
            throw new IfNotBoolOrNull();
        }
        executeStmtList(node.getThenStmtList());
        executeStmtList(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
        node.getExp().apply(expTypeChecker);
        if (expTypeChecker.getValue() == null || !(expTypeChecker.getValue().getValue() instanceof Boolean)) {
            throw new IfNotBoolOrNull();
        }
        executeStmtList(node.getThenStmtList());
    }

    public StmtTypeChecker(FormInterpreter formInterpreter) {
        super(formInterpreter);
    }

}
