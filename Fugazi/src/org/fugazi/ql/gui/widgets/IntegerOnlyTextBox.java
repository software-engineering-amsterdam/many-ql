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
        NumberFormatter numberFormatter = new NumberFormatter(intFormat);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0);

        this.input = new JFormattedTextField(numberFormatter);
        
        input.setColumns(7);

        panel.add(label);
        panel.add(input);
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
        input.setText(_value);
    }
}
