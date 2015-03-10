package org.uva.qls.view.widget;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.qls.ast.QLSNode;

public class CheckBox extends Widget<QLSNode> {

	private static final long serialVersionUID = -3420602307117955901L;
	private final JCheckBox checkBox;

	public CheckBox(QLSNode widgetModel) {
		super(widgetModel);
		checkBox = new JCheckBox();
	}

	@Override
	public JComponent getWidget() {
		return checkBox;
	}
}
