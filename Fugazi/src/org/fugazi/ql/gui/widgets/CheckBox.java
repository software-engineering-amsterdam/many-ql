package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.BoolValue;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.EventListener;

public class CheckBox implements IWidget {

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
    public BoolValue getValue() {
        return new BoolValue(this.component.isSelected());
    }

    @Override
    public void setValue(ExpressionValue _value) {
        BoolValue value = (BoolValue) _value;
        this.component.setSelected(value.getValue());
    }
    
    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.component.setEnabled(false);
    }
}