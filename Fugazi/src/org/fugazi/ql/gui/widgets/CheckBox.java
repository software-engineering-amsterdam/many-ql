package org.fugazi.ql.gui.widgets;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.EventListener;

public class CheckBox implements IWidget<Boolean> {

    private final String label;
    
    private JCheckBox component;

    public CheckBox(String _label) {
        this.label = _label;
        component = new JCheckBox(this.label);
    }

    @Override
    public JComponent getJComponent() {
        return component;
    }

    @Override
    public void addEventListener(EventListener _listener) {
        component.addItemListener((ItemListener)_listener);
    }

    @Override
    public Boolean getValue() {
        return this.component.isSelected();
    }

    @Override
    public void setValue(Boolean _value) {
        this.component.setSelected(_value);
    }
    
    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.component.setEnabled(false);
    }
}
