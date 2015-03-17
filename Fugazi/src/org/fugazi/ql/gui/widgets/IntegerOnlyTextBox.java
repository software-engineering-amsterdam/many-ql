package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;
import org.fugazi.ql.gui.ui_elements.UIForm;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class IntegerOnlyTextBox implements IWidget{

    private static int COLUMNS = 7;

    private JFormattedTextField input;
    private JPanel panel;
    private NumberFormatter numberFormatter; 

    public IntegerOnlyTextBox(String _label) {
        this.panel = new JPanel();
        JLabel label = new JLabel(_label);

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setGroupingUsed(false);
        intFormat.setParseIntegerOnly(true);
        numberFormatter = new NumberFormatter(intFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);
        numberFormatter.setOverwriteMode(true);

        this.input = new JFormattedTextField(numberFormatter);

        this.input.setColumns(COLUMNS);

        this.panel.add(label);
        this.panel.add(input);
    }

    @Override
    public void render(UIForm _canvas) {
        _canvas.addWidget(this.panel);
    }

    @Override
    public void supress(UIForm _canvas){
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
    public IntValue getWidgetValue() {
        return new IntValue(Integer.parseInt(this.input.getText()));
    }

    @Override
    public void setWidgetValue(ExpressionValue _value) {
        IntValue value = (IntValue) _value;
        this.input.setText(Integer.toString(value.getValue()));
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.input.setEditable(false);
        numberFormatter.setAllowsInvalid(true);
        numberFormatter.setMinimum(-1000);
        numberFormatter.setOverwriteMode(false);
    }
}
