package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.ql.widgets.LabelQLWidget;
import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.exceptions.LabelNotAvailableException;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.headless.HeadlessFormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.typechecker.FormTypeChecker;

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

    public void setVisibility(String identifier) {
        try {
            headlessFormInterpreter.getLabelForField(identifier);
            widget.setVisible(true);
        } catch (LabelNotAvailableException e) {
            widget.setVisible(false);
        }
    }

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        JLabel questLbl = new JLabel(node.getStr().getText());
        widget.add(questLbl);
        TypeRenderer typeRenderer = new TypeRenderer(node.getIdent().getText(),headlessFormInterpreter,formTypeChecker);
        node.getType().apply(typeRenderer);
        widget.add(typeRenderer.getWidget());

        setVisibility(node.getIdent().getText());

        headlessFormInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                setVisibility(node.getIdent().getText());
            }
        });
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        JLabel questLbl = new JLabel(node.getStr().getText());
        LabelQLWidget valueLbl = new LabelQLWidget(node.getIdent().getText(), headlessFormInterpreter);
        widget.add(questLbl);
        widget.add(valueLbl.getWidget());

        setVisibility(node.getIdent().getText());

        headlessFormInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                setVisibility(node.getIdent().getText());
            }
        });
    }

    @Override
    public void caseAIfelseStmt(AIfelseStmt node) {
        widget.setLayout(new BoxLayout(widget, BoxLayout.Y_AXIS));
        renderStatements(node.getThenStmtList());
        renderStatements(node.getElseStmtList());
    }

    @Override
    public void caseAIfStmt(AIfStmt node) {
        widget.setLayout(new BoxLayout(widget, BoxLayout.Y_AXIS));
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
