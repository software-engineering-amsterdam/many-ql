package org.fugazi.ql.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.util.EventListener;

public class TextBox implements IWidget<String> {

    private final String label;

    private JTextField input;
    private JPanel panel;

    public TextBox(String _label) {
        this.label = _label;

        this.panel = new JPanel();
        JLabel label = new JLabel(this.label);
        this.input = new JTextField();

        this.input.setColumns(7);

        this.panel.add(label);
        this.panel.add(input);
    }

    @Override
    public JComponent getJComponent() {
        return this.panel;
    }

    @Override
    public void addEventListener(EventListener _listener) {
        this.input.getDocument().addDocumentListener((DocumentListener) _listener);
    }

    @Override
    public String getValue() {
        return this.input.getText();
    }

    @Override
    public void setValue(String _value) {
        this.input.setText(_value);
    }
}
