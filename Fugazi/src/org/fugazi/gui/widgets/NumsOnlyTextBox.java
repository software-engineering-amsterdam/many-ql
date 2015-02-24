package org.fugazi.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ItemListener;

public class NumsOnlyTextBox implements IWidget<String> {

    private final String label;

    // todo: generalize the component
    private JTextField input;
    private JPanel panel;

    public NumsOnlyTextBox(String _label) {
        this.label = _label;

        this.panel = new JPanel();
        JLabel label = new JLabel(this.label);
        this.input = new JTextField();
        
        // Todo: Will be taken from a Style Object in QLS.
        input.setColumns(7);

        panel.add(label);
        panel.add(input);
    }

    @Override
    public JComponent getJComponent() {
        return this.panel;
    }

    @Override
    public void addItemListener(ItemListener _listener) {
        throw new AssertionError();
    }

    @Override
    public void addDocumentListener(DocumentListener _listener) {
        this.input.getDocument().addDocumentListener(_listener);
    }

    @Override
    public String getValue() {
        return this.input.getText();
    }
}
