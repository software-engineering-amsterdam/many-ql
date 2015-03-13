package org.fugazi.ql.gui.widgets;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.EventListener;

public class IntegerOnlyTextBox implements IWidget<String> {

    private final String label;

    private JFormattedTextField input;
    private JPanel panel;

    public IntegerOnlyTextBox(String _label) {
        this.label = _label;

        this.panel = new JPanel();
        JLabel label = new JLabel(this.label);

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setGroupingUsed(false);
        intFormat.setParseIntegerOnly(true);
        NumberFormatter numberFormatter = new NumberFormatter(intFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);
        numberFormatter.setOverwriteMode(true);

        this.input = new JFormattedTextField(numberFormatter);

        this.input.setColumns(7);

        this.panel.add(label);
        this.panel.add(input);
        
        this.setValue("0");
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

    @Override
    public void setReadOnly(boolean _isReadonly) {
        this.input.setEnabled(false);
    }
}
