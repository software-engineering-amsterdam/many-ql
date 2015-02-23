package org.fugazi.gui.ui_elements;

import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.widgets.IWidget;

import java.util.Observable;

public abstract class UIElement extends Observable {

    protected IWidget widget;

    public UIElement() {

    }

    public abstract void setState(ExpressionValue _value);
    public abstract ExpressionValue getState();

    public IWidget getWidget() {
        return this.widget;
    }
}