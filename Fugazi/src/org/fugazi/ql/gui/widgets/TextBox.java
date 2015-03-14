package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.util.EventListener;

public class TextBox implements IWidget {

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
    public StringValue getValue() {
        return new StringValue(this.input.getText());
    }

    @Override
    public void setValue(ExpressionValue _value) {
        StringValue value = (StringValue) _value;
        this.input.setText(value.getValue());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.input.setEnabled(false);
    }
}
