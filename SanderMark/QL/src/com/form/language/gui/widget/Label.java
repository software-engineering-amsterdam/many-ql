package com.form.language.gui.widget;

import javax.swing.JLabel;

public class Label extends JLabel {

    private static final long serialVersionUID = 1L;
    private final String labelValue;

    public Label(String labelValue) {
	this.labelValue = labelValue;
	this.setText(labelValue);
    }

    public String getText() {
	return labelValue;
    }
}
