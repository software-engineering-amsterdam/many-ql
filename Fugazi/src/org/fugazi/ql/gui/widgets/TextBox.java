package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.StringValue;
import org.fugazi.ql.gui.ui_elements.UIForm;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextBox implements IWidget {

    private JTextField input;
    private JPanel panel;

    public TextBox(String _label) {
        this.panel = new JPanel();
        JLabel label = new JLabel(_label);
        this.input = new JTextField();

        this.input.setColumns(7);

        this.panel.add(label);
        this.panel.add(input);
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.panel);
    }

    @Override
    public void suppress(UIForm _canvas){
        _canvas.removeWidget(this.panel);
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
    }
}
