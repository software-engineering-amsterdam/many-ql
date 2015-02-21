package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public class UIBoolQuestion implements UIQuestion {

    private final JCheckBox checkBox;
    private final Question question;

    public UIBoolQuestion(Question _question) {
        this.question = _question;
        checkBox = new JCheckBox(this.question.getLabel());
    } 
    
    @Override
    public JComponent getComponent() {
        return this.checkBox;
    }
}
