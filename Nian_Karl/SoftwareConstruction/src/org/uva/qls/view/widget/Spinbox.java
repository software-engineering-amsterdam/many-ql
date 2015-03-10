package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JSpinner;

import org.uva.qls.ast.QLSNode;

public class Spinbox extends Widget<QLSNode> {

	private static final long serialVersionUID = 1475463795116091186L;
	private final JSpinner spinbox; 
	public Spinbox(QLSNode spinBoxModel) {
		super(spinBoxModel);
		spinbox = new JSpinner();
	}

	@Override
	public JComponent getWidget() {
		return spinbox;
	}

}
