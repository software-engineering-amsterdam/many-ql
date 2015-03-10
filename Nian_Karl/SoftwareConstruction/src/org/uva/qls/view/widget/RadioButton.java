package org.uva.qls.view.widget;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JRadioButton;

import org.uva.qls.ast.QLSNode;

public class RadioButton extends Widget<QLSNode>{

	private static final long serialVersionUID = -3964223419102019708L;
	private final ButtonGroup buttonGroup;

	public RadioButton(QLSNode radioButton) {
		super(radioButton);
		buttonGroup = new ButtonGroup();
		JRadioButton trueButton = new JRadioButton();
		JRadioButton falseButton = new JRadioButton();
		buttonGroup.add(trueButton);
		buttonGroup.add(falseButton);
	}

	@Override
	public JComponent getWidget() {
		throw new UnsupportedOperationException("Can't get component from a button group, use getButtonGroup() and enumerate through the JRadioButtons.");
	}
	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

}
