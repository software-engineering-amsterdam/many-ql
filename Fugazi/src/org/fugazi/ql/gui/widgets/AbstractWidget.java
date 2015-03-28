package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.gui.ui_elements.UIForm;

import javax.swing.*;

public abstract class AbstractWidget implements IWidget {

    protected JComponent component;
    
    public AbstractWidget() {
        this.component = new JPanel();
    }
    
    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.component);
    }

    @Override
    public void suppress(UIForm _canvas) {
        _canvas.removeWidget(this.component);
    }
}
