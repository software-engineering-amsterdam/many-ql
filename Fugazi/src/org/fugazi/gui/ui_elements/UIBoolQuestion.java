package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UIBoolQuestion extends UIQuestion {

    public UIBoolQuestion(Question _question) {
        super(_question);
        this.component = new JCheckBox(this.question.getLabel());
    }
}
