package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UITextQuestion extends UIQuestion {

    public UITextQuestion(Question _question) {
        super(_question);

        this.component = new JPanel();
        this.component.add(new JLabel(this.question.getLabel()));
        JFormattedTextField textOnlyField = new JFormattedTextField();
        textOnlyField.setColumns(10);
        this.component.add(textOnlyField);
    }
}

