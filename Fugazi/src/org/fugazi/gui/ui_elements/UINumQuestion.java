package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UINumQuestion implements UIQuestion {

    private final JPanel panel;
    private final Question question;

    public UINumQuestion(Question _question) {
        this.question = _question;
        
        panel = new JPanel();
        panel.add(new JLabel(this.question.getLabel()));
        JFormattedTextField numOnlyField = new JFormattedTextField();
        numOnlyField.setColumns(10);
        panel.add(numOnlyField);
    }

    @Override
    public JComponent getComponent() {
        return this.panel;
    }
}
