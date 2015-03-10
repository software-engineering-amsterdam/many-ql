package org.uva.qls.view.widget;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.ql.ast.Node;

public class CheckBox extends Widget<Node> {

	private static final long serialVersionUID = -3420602307117955901L;
	private final JCheckBox checkBox;

	public CheckBox(Node widgetModel) {
		super(widgetModel);
		checkBox = new JCheckBox();
	}

	@Override
	public JComponent getWidget() {
		return checkBox;
	}
}
