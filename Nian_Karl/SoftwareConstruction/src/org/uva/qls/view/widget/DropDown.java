package org.uva.qls.view.widget;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import org.uva.ql.ast.Node;

public class DropDown extends Widget<Node> {

	private static final long serialVersionUID = -5817953538279717870L;
	private JComboBox<Boolean> comboBox;

	public DropDown(Node dropDownModel) {
		super(dropDownModel);
		comboBox = new JComboBox<Boolean>();
		comboBox.addItem(true);
		comboBox.addItem(false);
	}

	@Override
	public JComponent getWidget() {
		return comboBox;
	}
}
