package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UINumQuestion implements UIQuestion {

    private final JPanel panel;
    private final Question question;

    public UINumQuestion(Question _question) {
        this.question = _question;
        
        panel = new JPanel();
        panel.add(new JTextField());
        panel.add(new JLabel(this.question.getLabel()));
    }

    @Override
    public JComponent getComponent() {
        return this.panel;
    }
}
