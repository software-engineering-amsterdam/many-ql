package org.fugazi.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;
public class CheckBox implements IWidget<Boolean> {

    private final String label;

    // todo: generalize the component
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
    public void addItemListener(ItemListener _listener) {
        component.addItemListener(_listener);
    }

    @Override
    public void addDocumentListener(DocumentListener _listener) {
        throw new AssertionError();
    }
    
    @Override
    public Boolean getValue() {
        return this.component.isSelected();
    }

    @Override
    public void setValue(Boolean _value) {
        this.component.setSelected(_value);
    }
}
