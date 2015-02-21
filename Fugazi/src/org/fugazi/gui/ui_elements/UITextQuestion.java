package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UITextQuestion implements UIQuestion {

    private final JPanel panel;
    private final Question question;

    public UITextQuestion(Question _question) {
        this.question = _question;

        panel = new JPanel();
        panel.add(new JLabel(this.question.getLabel()));
        JFormattedTextField textOnlyField = new JFormattedTextField();
        textOnlyField.setColumns(10);
        panel.add(textOnlyField);
    }

    @Override
    public JComponent getComponent() {
        return this.panel;
    }
}

