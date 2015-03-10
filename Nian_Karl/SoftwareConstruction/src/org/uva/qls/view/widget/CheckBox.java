package org.uva.qls.view.widget;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.ql.ast.QLNode;

public class CheckBox extends Widget<QLNode> {

	private static final long serialVersionUID = -3420602307117955901L;
	private final JCheckBox checkBox;

	public CheckBox(QLNode widgetModel) {
		super(widgetModel);
		checkBox = new JCheckBox();
	}

	@Override
	public JComponent getWidget() {
		return checkBox;
	}
}
