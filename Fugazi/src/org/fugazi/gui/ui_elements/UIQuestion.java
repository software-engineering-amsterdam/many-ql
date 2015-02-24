package org.fugazi.gui.ui_elements;

import org.fugazi.ast.expression.literal.ID;
import org.fugazi.ast.statement.Question;
import org.fugazi.gui.UIMediator;

public abstract class UIQuestion extends UIElement {

    protected final Question question;

    UIQuestion(UIMediator _med, Question _question) {
        super(_med);
        this.question = _question;
    }

    public ID getId() {
        return question.getIdentifier();
    }
}
