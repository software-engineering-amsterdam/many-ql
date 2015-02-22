package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.ComputedQuestion;

import javax.swing.*;

public class UIComputedQuestion extends UIQuestion {

    public UIComputedQuestion(ComputedQuestion _question) {
        super(_question);

        this.component = new JPanel();
        this.component.add(new JLabel(this.question.getLabel()));
        //component.add(new JLabel(this.question.getLabel()));
    }
}
