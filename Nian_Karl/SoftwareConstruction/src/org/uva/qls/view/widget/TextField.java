package org.uva.qls.view.widget;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.ql.ast.QLNode;
import org.uva.qls.ast.QLSNode;

public class TextField extends Widget<QLSNode> {
	
	private static final long serialVersionUID = -8088269830348403749L;
	private final JTextField textfield;
	public TextField(QLSNode textFieldModel) {
		super(textFieldModel);
		textfield = new JTextField();
	}

	@Override
	public JComponent getWidget() {
		return textfield;
	}
}
