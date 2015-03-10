package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.ql.ast.Node;

public class TextField extends Widget<Node> {
	
	private static final long serialVersionUID = -8088269830348403749L;
	private final JTextField textfield;
	public TextField(Node textFieldModel) {
		super(textFieldModel);
		textfield = new JTextField();
	}

	@Override
	public JComponent getWidget() {
		return textfield;
	}
}
