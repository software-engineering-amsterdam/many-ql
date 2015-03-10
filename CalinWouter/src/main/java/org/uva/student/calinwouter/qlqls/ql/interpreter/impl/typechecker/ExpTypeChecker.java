package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.Value;

public class ExpTypeChecker extends AnalysisAdapter {
    private FormTypeChecker formInterpreter;
    private Value<?> value;

    @Override
    public void caseAAddExp(AAddExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseASubExp(ASubExp node) {
        setValue(interpExp(node.getLeft()).sub(interpExp(node.getRight())));
    }

    @Override
    public void caseAOrExp(AOrExp node) {
        setValue(interpExp(node.getLeft()).or(interpExp(node.getRight())));
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        setValue(interpExp(node.getLeft()).and(interpExp(node.getRight())));
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        setValue(interpExp(node.getLeft()).eq(interpExp(node.getRight())));
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        setValue(interpExp(node.getLeft()).neq(interpExp(node.getRight())));
    }

    @Override
    public void caseALtExp(ALtExp node) {
        setValue(interpExp(node.getLeft()).lt(interpExp(node.getRight())));
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        setValue(interpExp(node.getLeft()).gt(interpExp(node.getRight())));
    }

    @Override
    public void caseALteExp(ALteExp node) {
        setValue(interpExp(node.getLeft()).lte(interpExp(node.getRight())));
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        setValue(interpExp(node.getLeft()).gte(interpExp(node.getRight())));
    }

    @Override
    public void caseAMulExp(AMulExp node) {
        setValue(interpExp(node.getLeft()).mul(interpExp(node.getRight())));
    }

    @Override
    public void caseADivExp(ADivExp node) {
        setValue(interpExp(node.getLeft()).div(interpExp(node.getRight())));
    }

    @Override
    public void caseAModExp(AModExp node) {
        setValue(interpExp(node.getLeft()).mod(interpExp(node.getRight())));
    }

    @Override
    public void caseANotExp(ANotExp node) {
        setValue(interpExp(node.getExp()).not());
    }

    @Override
    public void caseAIdentExp(AIdentExp node) {
        /*Value<?> value = (formInterpreter.getField(node.getIdent().getText()));
        if (value == null) {
            throw new VariableNotSetException(node.getIdent().getText());
        }
        setValue(value);*/
    }

    private Value<?> interpExp(Node n) {
        //ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        //n.apply(expInterpreter);
        //return expInterpreter.getValue();
        ExpTypeChecker expTypeChecker = new ExpTypeChecker(formInterpreter);
        n.apply(expTypeChecker);
        return expTypeChecker.getValue();
    }

    protected void setValue(Value<?> value) {
        this.value = value;
    }

    public Value<?> getValue() {
        return value;
    }

    @Override
    public void caseANumberExp(ANumberExp node) {
        setValue(new IntegerValue(null));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        setValue(new BoolValue(null));
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        setValue(new BoolValue(null));
    }

    public ExpTypeChecker(FormTypeChecker formInterpreter) {
        //super(formInterpreter);
        this.formInterpreter = formInterpreter;
    }

}