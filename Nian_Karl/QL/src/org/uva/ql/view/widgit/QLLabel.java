package org.uva.ql.view.widgit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class QLLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	private final String labelValue;
	
	public QLLabel(String labelValue) {
		this.labelValue = labelValue;
		this.setText(labelValue);
		this.setHorizontalAlignment(SwingConstants.LEFT);
	}
	
	public String getText() {
		return labelValue;
	}
	
}
