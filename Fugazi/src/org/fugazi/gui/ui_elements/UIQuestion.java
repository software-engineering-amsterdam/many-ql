package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

import javax.swing.*;

public abstract class UIQuestion implements IUIElement {

    protected final Question question;
    protected JComponent component;

    UIQuestion(Question _question) {
        this.question = _question;
    }

    @Override
    public JComponent getComponent() {
        return this.component;
    }
}
