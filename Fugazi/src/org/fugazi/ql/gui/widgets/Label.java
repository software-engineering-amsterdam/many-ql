package org.fugazi.ql.gui.widgets;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

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
    public void addEventListener(EventListener _listener) {
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
