package com.form.language.gui.widget;

import javax.swing.JLabel;

public class Label {

	private JLabel label;

	public Label(String labelValue) {
		this.label = new JLabel();
		this.label.setText(labelValue);
	}

	public JLabel getLabel() {
		return this.label;
	}
}
