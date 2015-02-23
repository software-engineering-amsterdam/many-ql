package org.fugazi.gui.ui_elements;

import org.fugazi.gui.widgets.IWidget;

import java.util.Observable;

public abstract class IUIElement extends Observable {

    protected IWidget widget;

    public IWidget getWidget() {
        return this.widget;
    }
}