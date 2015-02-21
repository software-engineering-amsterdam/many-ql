package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UIComputedQuestion implements UIQuestion {

    private final JPanel panel;
    private final Question question;

    public UIComputedQuestion(ComputedQuestion _question) {
        this.question = _question;

        panel = new JPanel();
        panel.add(new JLabel(this.question.getLabel()));
        //panel.add(new JLabel(this.question.getLabel()));
    }

    @Override
    public JComponent getComponent() {
        return this.panel;
    }
}
