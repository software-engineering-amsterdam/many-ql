package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.gui.widgets.IWidget;

public abstract class UIQuestion implements IUIElement {

    protected final Question question;
    protected IWidget widget;

    UIQuestion(Question _question) {
        this.question = _question;
    }

    @Override
    public IWidget getWidget() {
        return this.widget;
    }
}
