package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.EventListener;

public class IntegerOnlyTextBox implements IWidget{

    private final String label;

    private JFormattedTextField input;
    private JPanel panel;
    private NumberFormatter numberFormatter; 

    public IntegerOnlyTextBox(String _label) {
        this.label = _label;

        this.panel = new JPanel();
        JLabel label = new JLabel(this.label);

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setGroupingUsed(false);
        intFormat.setParseIntegerOnly(true);
        numberFormatter = new NumberFormatter(intFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);
        numberFormatter.setOverwriteMode(true);

        this.input = new JFormattedTextField(numberFormatter);

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
    public IntValue getValue() {
        return new IntValue(Integer.parseInt(this.input.getText()));
    }

    @Override
    public void setValue(ExpressionValue _value) {
        IntValue value = (IntValue) _value;
        this.input.setText(value.getValue().toString());
    }

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.input.setEnabled(false);
        numberFormatter.setAllowsInvalid(true);
        numberFormatter.setMinimum(-1000);
        numberFormatter.setOverwriteMode(false);
    }
}
