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

	public RadioButton(Identifier identifier, ValueEnvironment controller) {
		super(identifier, controller);
		
		radioButton = new JRadioButton();
		radioButton.addChangeListener(this);
	}
	public RadioButton(Identifier identifier, ValueEnvironment controller, boolean enabled) {
		this(identifier, controller);
		radioButton.setEnabled(enabled);
	}

	@Override
	public void setValue(Value value) {
		try {
			radioButton.setSelected(((BooleanValue)value).getValue());
			setChanged();
			valueEnv.store(getIdentifier(), value);

			notifyObservers();
		}
		catch (ClassCastException e) {
			// value is of type Undefined
		}
	}

	@Override
	public JComponent getComponent() {
		return radioButton;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Value value = new BooleanValue(radioButton.isSelected());
		setChanged();
		valueEnv.store(getIdentifier(), value);

		notifyObservers();
	}
}
