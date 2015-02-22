package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UINumQuestion extends UIQuestion {

    public UINumQuestion(Question _question) {
        super(_question);

        this.component = new JPanel();
        this.component.add(new JLabel(this.question.getLabel()));
        JFormattedTextField numOnlyField = new JFormattedTextField();
        numOnlyField.setColumns(10);
        this.component.add(numOnlyField);
    }
}
