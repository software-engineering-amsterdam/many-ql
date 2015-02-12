package org.uva.student.calinwouter.ql.interpreter.components;

import org.uva.student.calinwouter.ql.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.ql.generated.analysis.DepthFirstAdapter;
import org.uva.student.calinwouter.ql.generated.node.*;
import org.uva.student.calinwouter.ql.interpreter.components.types.TBool;
import org.uva.student.calinwouter.ql.interpreter.components.types.TInteger;
import org.uva.student.calinwouter.ql.interpreter.components.types.TypeModel;

import java.util.Map;

public class ExpInterpreter extends AnalysisAdapter {
    private TypeModel<?> value;
    private FormInterpreter formInterpreter;

    @Override
    public void caseAAddExp(AAddExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseASubExp(ASubExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        setValue(new TBool(true));
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        setValue(new TBool(false));
    }

    @Override
    public void caseAOrExp(AOrExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseALtExp(ALtExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseALteExp(ALteExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseAMulExp(AMulExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseADivExp(ADivExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseAModExp(AModExp node) {
        setValue(interpExp(node.getLeft()).add(interpExp(node.getRight())));
    }

    @Override
    public void caseANotExp(ANotExp node) {
        setValue(interpExp(node.getExp()).not());
    }

    @Override
    public void caseANumberExp(ANumberExp node) {
        setValue(new TInteger(Integer.parseInt(node.getNumber().getText())));
    }

    @Override
    public void caseAIdentExp(AIdentExp node) {
        TypeModel<?> value = (formInterpreter.getField(node.getIdent().getText()));
        if (value == null) {
            throw new InterpretationException("Variable was not set.");
        }
        setValue(value);
    }

    private TypeModel<?> interpExp(Node n) {
        ExpInterpreter expInterpreter = new ExpInterpreter(formInterpreter);
        n.apply(expInterpreter);
        return expInterpreter.getValue();
    }

    private void setValue(TypeModel<?> value) {
        this.value = value;
    }

    public TypeModel<?> getValue() {
        return value;
    }

    public ExpInterpreter(FormInterpreter formInterpreter) {
        super();
        this.formInterpreter = formInterpreter;
    }
}
