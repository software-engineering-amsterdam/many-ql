package org.fugazi.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemListener;

public class Label implements IWidget<String> {

    private final JLabel value;

    private JPanel panel;

    public Label(String _label, String _value) {

        this.panel = new JPanel();
        JLabel label = new JLabel(_label);
        this.value = new JLabel(_value);

        value.setFont(new Font(value.getName(), Font.BOLD, 14));

        panel.add(label);
        panel.add(this.value);
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
    }

    @Override
    public String getValue() {
        return this.value.getText();
    }

    @Override
    public void setValue(String _value) {
        value.setText(_value);
    }
}
