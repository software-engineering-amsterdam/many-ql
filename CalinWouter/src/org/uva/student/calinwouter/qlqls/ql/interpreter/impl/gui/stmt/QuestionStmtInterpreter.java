package org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt;

import org.uva.student.calinwouter.qlqls.generated.node.AQuestionStmt;
import org.uva.student.calinwouter.qlqls.ql.interpreter.FormInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeCallback;
import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt.question.GuiBooleanQuestionStmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt.question.GuiIntegerQuestionStmtInterpreter;
import org.uva.student.calinwouter.qlqls.ql.interpreter.impl.gui.stmt.question.GuiStringQuestionStmtInterpreter;

import javax.swing.*;
import java.awt.*;

public class QuestionStmtInterpreter implements TypeCallback {
    private JPanel jPanel;
    private final AQuestionStmt node;
    private final FormInterpreter formInterpreter;

    public void interpret() {
        formInterpreter.registerFieldUse(node.getIdent().getText());
        formInterpreter.registerLabelUse(node.getStr().getText());
        TypeInterpreter typeInterpreter = new TypeInterpreter();
        node.getType().apply(typeInterpreter);
        typeInterpreter.getValue().callTypeMethod(this);
    }

    private void createFormElement(Component editComponent) {
        GridBagConstraints cTitle = new GridBagConstraints();
        GridBagConstraints cEditComponent;
        Label lblTitle = new Label(node.getStr().getText());
        cTitle.fill = GridBagConstraints.HORIZONTAL;
        cTitle.ipady = 0;
        cTitle.anchor = GridBagConstraints.PAGE_START;
        cTitle.insets = new Insets(10,0,0,0);
        cTitle.gridx = 0;
        cTitle.weightx = .25;
        cTitle.gridwidth = 1;
        cEditComponent = (GridBagConstraints) cTitle.clone();
        cEditComponent.gridx = 1;
        cEditComponent.weightx = .75;
        jPanel.add(lblTitle, cTitle);
        jPanel.add(editComponent, cEditComponent);
    }

    @Override
    public void usesBoolean() {
        createFormElement(new GuiBooleanQuestionStmtInterpreter(formInterpreter, node).interpret());
    }

    @Override
    public void usesInteger() {
        createFormElement(new GuiIntegerQuestionStmtInterpreter(formInterpreter, node).interpret());
    }

    @Override
    public void usesString() {
        createFormElement(new GuiStringQuestionStmtInterpreter(formInterpreter, node).interpret());
    }

    public QuestionStmtInterpreter(JPanel jPanel, FormInterpreter formInterpreter, AQuestionStmt node) {
        this.jPanel = jPanel;
        this.formInterpreter = formInterpreter;
        this.node = node;
    }
}
