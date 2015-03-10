package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JSpinner;

import org.uva.ql.ast.QLNode;

public class Spinbox extends Widget<QLNode> {

	private static final long serialVersionUID = 1475463795116091186L;
	private final JSpinner spinbox; 
	public Spinbox(QLNode spinBoxModel) {
		super(spinBoxModel);
		spinbox = new JSpinner();
	}

	@Override
	public JComponent getWidget() {
		return spinbox;
	}

}
