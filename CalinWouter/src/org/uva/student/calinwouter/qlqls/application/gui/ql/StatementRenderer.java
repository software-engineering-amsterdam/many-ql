package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;
import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class StatementRenderer extends AnalysisAdapter {
    private HeadlessFormInterpreter headlessFormInterpreter;
    private FormTypeChecker formTypeChecker;
    private JPanel widget;

    public StatementRenderer(HeadlessFormInterpreter headlessFormInterpreter, FormTypeChecker formTypeChecker) {
        widget = new JPanel();
        this.headlessFormInterpreter = headlessFormInterpreter;
        this.formTypeChecker = formTypeChecker;
    }

    public Component getWidget() {
        return widget;
    }

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        JLabel questLbl = new JLabel(node.getStr().getText());
        //TODO add widget based on the type (checkbox for bool/textbox for int and string)
        widget.add(questLbl);
        try {
            //TODO here is where I should start working on
            headlessFormInterpreter.getField(node.getIdent().getText());
            widget.setVisible(true);
        } catch (NullPointerException e) {
            widget.setVisible(false);
            System.out.println("got null exception for " + node.getIdent().getText());
        }
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        JLabel questLbl = new JLabel(node.getStr().getText());
        JLabel valueLbl = new JLabel();
        try {
            valueLbl.setText(headlessFormInterpreter.getField(node.getIdent().getText()).toString());
            widget.setVisible(true);
        }catch (NullPointerException e) {
            valueLbl.setText("-");
            widget.setVisible(false);
        }
        widget.add(questLbl);
        widget.add(valueLbl);
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        renderStatements(node.getThenStmtList());
        renderStatements(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        renderStatements(node.getThenStmtList());
    }

    public void renderStatements(LinkedList<PStmt> statements) {
        for(PStmt s: statements) {
            StatementRenderer statementRenderer = new StatementRenderer(headlessFormInterpreter, formTypeChecker);
            s.apply(statementRenderer);
            widget.add(statementRenderer.getWidget());
        }
    }
}
