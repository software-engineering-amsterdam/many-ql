package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JSpinner;

import org.uva.ql.ast.Node;

public class Spinbox extends Widget<Node> {

	private static final long serialVersionUID = 1475463795116091186L;
	private final JSpinner spinbox; 
	public Spinbox(Node spinBoxModel) {
		super(spinBoxModel);
		spinbox = new JSpinner();
	}

	@Override
	public JComponent getWidget() {
		return spinbox;
	}

}
