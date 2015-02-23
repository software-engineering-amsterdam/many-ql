package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

public abstract class UIQuestion extends UIElement {

    protected final Question question;

    UIQuestion(Question _question) {
        this.question = _question;
    }
}
