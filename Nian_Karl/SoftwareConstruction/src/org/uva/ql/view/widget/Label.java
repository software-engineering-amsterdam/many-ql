package org.uva.ql.view.widget;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label extends JLabel{

	private static final long serialVersionUID = 1L;
	private final String labelValue;
	
	public Label(String labelValue) {
		this.labelValue = labelValue;
		this.setText(labelValue);
		this.setHorizontalAlignment(SwingConstants.LEFT);
	}
	
	public String getText() {
		return labelValue;
	}
}
