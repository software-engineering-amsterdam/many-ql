package org.uva.student.calinwouter.ql.ast;

import org.uva.student.calinwouter.ql.ast.exp.*;
import org.uva.student.calinwouter.ql.ast.type.BooleanType;
import org.uva.student.calinwouter.ql.ast.type.IntegerType;
import org.uva.student.calinwouter.ql.ast.type.StringType;
import org.uva.student.calinwouter.ql.generated.analysis.Analysis;
import org.uva.student.calinwouter.ql.generated.analysis.DepthFirstAdapter;
import org.uva.student.calinwouter.ql.generated.node.*;

import java.util.LinkedList;

public class AstConverter extends DepthFirstAdapter {

    LinkedList<AstElement> elements;

    private void pushElement(AstElement astElement) {

    }

    private AstElement popElement() {
        return null;
    }

//    private Exp popExpression() {
//        return (Exp) popElement();
//    }

    @Override
    public Object getIn(Node node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setIn(Node node, Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getOut(Node node) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setOut(Node node, Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseStart(Start node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAFormBegin(AFormBegin node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAExpBegin(AExpBegin node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAForm(AForm node) {
        pushElement(new Form(((TIdent) popElement()).getText(), (List<QuestionStmt>) popElement()));
    }

    @Override
    public void caseASingleStmtlist(ASingleStmtlist node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAMultiStmtlist(AMultiStmtlist node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseASingleStmt(ASingleStmt node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAQuestionStmt(AQuestionStmt node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAValueStmt(AValueStmt node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void caseABoolType(ABoolType node) {
        pushElement(new BooleanType());
    }

    @Override
    public void caseAStringType(AStringType node) {
        pushElement(new StringType());
    }

    @Override
    public void caseAIntType(AIntType node) {
        pushElement(new IntegerType());
    }

    @Override
    public void caseAAddExp(AAddExp node) {
        pushElement(new AddExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseASubExp(ASubExp node) {
        //To change body of implemented methods use File | Settings | File Templates.
        pushElement(new SubExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseATrueExp(ATrueExp node) {
        pushElement(new TrueExp());
    }

    @Override
    public void caseAFalseExp(AFalseExp node) {
        pushElement(new FalseExp());
    }

    @Override
    public void caseAOrExp(AOrExp node) {
        pushElement(new OrExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAAndExp(AAndExp node) {
        pushElement(new AndExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAEqExp(AEqExp node) {
        pushElement(new EqExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseANeqExp(ANeqExp node) {
        pushElement(new NeqExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseALtExp(ALtExp node) {
        pushElement(new LtExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAGtExp(AGtExp node) {
        pushElement(new GtExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseALteExp(ALteExp node) {
        pushElement(new LteExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAGteExp(AGteExp node) {
        pushElement(new GteExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAMulExp(AMulExp node) {
        pushElement(new MulExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseADivExp(ADivExp node) {
        pushElement(new DivExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAModExp(AModExp node) {
        pushElement(new ModExp((Exp) popElement(), (Exp) popElement()));
    }

    @Override
    public void caseAParenExp(AParenExp node) {
        // TODO remove?
        pushElement(new ParenExp((Exp) popElement()));
    }

    @Override
    public void caseANotExp(ANotExp node) {
        pushElement(new NotExp((Exp) popElement()));
    }

    @Override
    public void caseANumberExp(ANumberExp node) {
        Integer i = Integer.parseInt(node.getNumber().getText());
        pushElement(new NumberExp(i));
    }

    @Override
    public void caseAIdentExp(AIdentExp node) {
        pushElement(new IdentExp(node.getIdent().getText()));
    }

}
