package org.fugazi.gui.widgets;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.EventListener;

public class TextBox implements IWidget {

    private final String label;

    public TextBox(String _label) {
        this.label = _label;
    }

    @Override
    public JComponent getJComponent() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(this.label);
        JTextField input = new JTextField();

        // Todo: Will be taken from a Style Object in QLS.
        input.setColumns(7);

        panel.add(label);
        panel.add(input);

        return panel;
    }

    @Override
    public void addEventListener(EventListener listener) {

    }
}
