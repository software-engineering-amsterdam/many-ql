package gui.widgets;

import gui.Controller;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cons.Value;
import cons.ql.ast.expression.Identifier;
import cons.value.BooleanValue;

public class RadioButton extends Widget implements ChangeListener {
	
	private JRadioButton radioButton;

	public RadioButton(Identifier identifier, Controller controller) {
		super(identifier, controller);
		
		radioButton = new JRadioButton();
		radioButton.addChangeListener(this);
	}
	public RadioButton(Identifier identifier, Controller controller, boolean enabled) {
		this(identifier, controller);
		radioButton.setEnabled(enabled);
	}

	@Override
	public void setValue(Value value) {
		try {
			radioButton.setSelected(((BooleanValue)value).getValue());
			setChanged();
			getController().getValueEnvironment().store(getIdentifier(), value);
			getController().notify(getIdentifier());
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
		getController().getValueEnvironment().store(getIdentifier(), value);
		getController().notify(getIdentifier());
	}
}
