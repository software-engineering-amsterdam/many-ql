package gui.widgets;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;
import cons.value.BooleanValue;

public class RadioButton extends Widget implements ChangeListener {
	
	private JRadioButton radioButton;

	public RadioButton(Identifier identifier, ValueEnvironment valueEnv) {
		super(identifier, valueEnv);
		
		radioButton = new JRadioButton();
		radioButton.addChangeListener(this);
	}
	public RadioButton(Identifier identifier, ValueEnvironment valueEnv, boolean enabled) {
		this(identifier, valueEnv);
		radioButton.setEnabled(enabled);
	}

	@Override
	public void setValue(Value value) {
		if (value.isUndefined()) {
			return;
		}

		radioButton.setSelected(((BooleanValue)value).getValue());
		storeAndNotify(getIdentifier(), value);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Value value = new BooleanValue(radioButton.isSelected());
		storeAndNotify(getIdentifier(), value);
	}

	@Override
	public JComponent getComponent() {
		return radioButton;
	}
}
