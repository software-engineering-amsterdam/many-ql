package org.fugazi.gui.widgets;

import javax.swing.*;

public class TextBox extends JPanel implements IWidget {

    private final JTextField valueField;
    private final JLabel label;

    public TextBox(String _label) {
        this.valueField = new JTextField();
        this.label = new JLabel(_label);
        this.add(this.label);
        this.valueField.setColumns(7);
        this.add(this.valueField);
    }

    public JTextField getTextField() {
        return this.valueField;
    }
}
