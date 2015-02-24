package org.fugazi.gui.widgets;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.EventListener;

public class RadioBtn implements IWidget {

    private final String label;

    public RadioBtn(String _label) {
        this.label = _label;
    }

    @Override
    public JComponent getJComponent() {
        JRadioButton component = new JRadioButton(this.label);
        return component;
    }

    @Override
    public void addEventListener(EventListener listener) {

    }
}
