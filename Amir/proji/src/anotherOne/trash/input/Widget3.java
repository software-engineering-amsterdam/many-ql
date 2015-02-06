package anotherOne.gui.input;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public enum Widget3 {

	TEXTFIELD(new JTextField()), CHECKBOX(new JCheckBox());

	private final JComponent component;

	Widget3 (JComponent component){
		this.component = component;
	}
}
