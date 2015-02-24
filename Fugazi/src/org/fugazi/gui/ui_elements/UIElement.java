package org.fugazi.gui.ui_elements;

import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.UIMediator;
import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.widgets.IWidget;

public abstract class UIElement extends Colleague {

    protected IWidget widget;

    public UIElement(UIMediator _med) {
        super(_med);
    }

    public abstract void setState(ExpressionValue _value);
    public abstract ExpressionValue getState();

    public IWidget getWidget() {
        return this.widget;
    }

    @Override
    public void receive(String message) {
        // todo: YANGI?
    }
}