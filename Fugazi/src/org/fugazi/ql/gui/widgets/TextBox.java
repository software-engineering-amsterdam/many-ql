package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextBox extends AbstractWidget {

    private JTextField input;

    public TextBox(String _label) {
        JLabel label = new JLabel(_label);
        this.input = new JTextField();

        this.input.setColumns(7);

        this.component.add(label);
        this.component.add(input);
    }

    @Override
    public void addEventListener(WidgetsEventListener _listener) {

        this.input.getDocument().addDocumentListener(
            new DocumentListener() {
                public void insertUpdate(DocumentEvent e) {
                    _listener.stateChanged();
                }
                public void removeUpdate(DocumentEvent e) {}
                public void changedUpdate(DocumentEvent e) {}
            }
        );
    }

    @Override
    public StringValue getWidgetValue() {
        return new StringValue(this.input.getText());
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        StringValue value = (StringValue) _value;
        this.input.setText(value.getValue());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.input.setEditable(false);
        this.input.setEditable(false);
    }
}
