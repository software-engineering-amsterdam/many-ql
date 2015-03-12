package org.uva.student.calinwouter.qlqls.application.gui.ql;

import org.uva.student.calinwouter.qlqls.application.gui.ql.widgets.LabelQLWidget;
import org.uva.student.calinwouter.qlqls.generated.analysis.AnalysisAdapter;
import org.uva.student.calinwouter.qlqls.generated.node.*;
import org.uva.student.calinwouter.qlqls.ql.interpreter.ChangedStateEventListener;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.typechecker.FormTypeChecker;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class StatementRenderer extends AnalysisAdapter {
    private FormInterpreter formInterpreter;
    private FormTypeChecker formTypeChecker;
    private final JPanel widget;

    public StatementRenderer(FormInterpreter formInterpreter, FormTypeChecker formTypeChecker) {
        widget = new JPanel();
        this.formInterpreter = formInterpreter;
        this.formTypeChecker = formTypeChecker;
    }

    public Component getWidget() {
        return widget;
    }

    @Override
    public void caseAQuestionStmt(final AQuestionStmt node) {
        JLabel questLbl = new JLabel(node.getStr().getText());
        widget.add(questLbl);
        TypeRenderer typeRenderer = new TypeRenderer(node.getIdent().getText(), formInterpreter, formTypeChecker);
        node.getType().apply(typeRenderer);
        widget.add(typeRenderer.getWidget());

        widget.setVisible(formInterpreter.hasField(node.getIdent().getText()));

        formInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                widget.setVisible(formInterpreter.hasField(node.getIdent().getText()));
            }
        });
    }

    @Override
    public void caseAValueStmt(final AValueStmt node) {
        JLabel questLbl = new JLabel(node.getStr().getText());
        LabelQLWidget valueLbl = new LabelQLWidget(node.getIdent().getText(), formInterpreter);
        widget.add(questLbl);
        widget.add(valueLbl.getWidget());

        widget.setVisible(formInterpreter.hasField(node.getIdent().getText()));

        formInterpreter.subscribeChangedStateEventListener(new ChangedStateEventListener() {
            @Override
            public void onStateChanged() {
                widget.setVisible(formInterpreter.hasField(node.getIdent().getText()));
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
        for (PStmt s : statements) {
            StatementRenderer statementRenderer = new StatementRenderer(formInterpreter, formTypeChecker);
            s.apply(statementRenderer);
            widget.add(statementRenderer.getWidget());
        }
    }
}
