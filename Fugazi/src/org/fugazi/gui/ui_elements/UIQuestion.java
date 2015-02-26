package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.widgets.IWidget;

public abstract class UIQuestion extends Colleague {

    protected IWidget widget;
    protected final Question question;

    UIQuestion(IMediator _med, Question _question) {
        super(_med);
        this.question = _question;
    }

    public abstract ExpressionValue getState();

    @Override
    public String getId() {
        return question.getIdName();
    }

    public IWidget getWidget() {
        return this.widget;
    }

    @Override
    public void receive(String message) {
        // todo: YANGI?
    }
}
