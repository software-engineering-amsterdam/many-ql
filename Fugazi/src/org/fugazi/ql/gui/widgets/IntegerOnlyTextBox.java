package org.fugazi.ql.gui.widgets;

import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.evaluator.expression_value.IntValue;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class IntegerOnlyTextBox extends AbstractWidget {

    private static int COLUMNS = 7;
    private static int MIN_NUM = -1000000;
    private static int MAX_NUM = 1000000;

    private JFormattedTextField input;
    private NumberFormatter numberFormatter; 

    public IntegerOnlyTextBox(String _label) {
        JLabel label = new JLabel(_label);

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setGroupingUsed(false);
        intFormat.setParseIntegerOnly(true);
        
        numberFormatter = new NumberFormatter(intFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(MIN_NUM);
        numberFormatter.setMaximum(MAX_NUM);
        numberFormatter.setOverwriteMode(true);

        this.input = new JFormattedTextField(numberFormatter);

        this.input.setColumns(COLUMNS);

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
    }
}
