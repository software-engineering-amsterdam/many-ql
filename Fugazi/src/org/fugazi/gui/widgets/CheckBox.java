package org.fugazi.gui.widgets;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.EventListener;

public class CheckBox implements IWidget {

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
    public void addEventListener(EventListener listener) {
        // todo: fix that
        component.addItemListener((ItemListener)listener);
    }
}
