package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.exceptions.IfNotBoolOrNullException;
import org.uva.student.calinwouter.qlqls.ql.exceptions.InvalidComputedValueTypeException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;

import java.util.LinkedList;

//public class StmtTypeChecker extends StmtInterpreter<FormTypeChecker> {
public class StmtTypeChecker extends AnalysisAdapter {
    // TODO rename it
    private final FormTypeChecker formInterpreter;

    // TODO apply most to the actual ql as well.
    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        formInterpreter.registerFieldUse(node.getIdent().getText());
        formInterpreter.registerLabelUse(node.getStr().getText());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        formInterpreter.setTypeDescriptor(node.getIdent().getText(), typeInterpreter.getValue());
        /*formInterpreter.setField(node.getIdent().getText(),
                typeInterpreter.getValue().getDefaultValue());*/
    }

    // TODO apply most to the actual ql as well.
    @Override
    public void caseAValueStmt(final AValueStmt node) {
        formInterpreter.registerFieldUse(node.getIdent().getText());
        formInterpreter.registerLabelUse(node.getStr().getText());

        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        /*formInterpreter.setField(node.getIdent().getText(),
                typeInterpreter.getValue().getDefaultValue());
*/
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
        node.getExp().apply(expTypeChecker);

        formInterpreter.setTypeDescriptor(node.getIdent().getText(), typeInterpreter.getValue());

        if (typeInterpreter.getValue().getDefaultValue().getTypeModelClass()
                != expTypeChecker.getValue().getTypeModelClass()) {

            // TODO outputs actual Java type.
            throw new InvalidComputedValueTypeException(
                    typeInterpreter.getValue().getDefaultValue().getTypeModelClass().toString(),
                    expTypeChecker.getValue().getTypeModelClass().toString());
        }
    }

    //protected StmtInterpreter createStmtInterpreter() {
    protected StmtTypeChecker createStmtInterpreter(){
        return new StmtTypeChecker(formInterpreter);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
        node.getExp().apply(expTypeChecker);
        if (expTypeChecker.getValue() == null || !(expTypeChecker.getValue().getValue() instanceof Boolean)) {
            throw new IfNotBoolOrNullException();
        }
        executeStmtList(node.getThenStmtList());
        executeStmtList(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
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
        //super(formTypeChecker);
        this.formInterpreter = formTypeChecker;
    }

}