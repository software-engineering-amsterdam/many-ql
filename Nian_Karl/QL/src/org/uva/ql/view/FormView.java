package org.uva.ql.view;

import javax.swing.JFrame;

public class FormView extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public FormView() {
		this.setSize(1200, 400);
		setVisible(true);
	}

	
	public void addView(ComponentView view) {
		this.add(view);
	}
}
