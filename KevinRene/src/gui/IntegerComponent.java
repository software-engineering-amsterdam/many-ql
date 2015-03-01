package gui;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import cons.Value;
import cons.ql.ast.expression.Identifier;
import cons.value.IntegerValue;

public class IntegerComponent extends TextComponent implements CaretListener {
	
	public IntegerComponent (Identifier identifier, Controller controller) {
		super(identifier, controller);
	}
	
	public IntegerComponent (Identifier identifier, Controller controller, boolean enabled) {
		super(identifier, controller, enabled);
	}

	@Override
	public void setValue(Value value) {
		
		System.out.println("Set value for " + getIdentifier() + " to " + value);
		
		// Update value of the JTextField
		textField.setText(value.toString());
		setChanged();
		
		// Store the new value in the TypeEnvironment
		controller.storeValue(getIdentifier(), value);
		
		// Notify this value has changed
		controller.notify(getIdentifier());
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		try {
			Value value = new IntegerValue(Integer.parseInt(textField.getText()));
			
			setChanged();
			
			// Store the new value in the TypeEnvironment
			controller.storeValue(getIdentifier(), value);
			
			// Notify this value has changed
			controller.notify(getIdentifier());

			removeError();
		}
		catch (NumberFormatException nfe) {
			setError("Not a valid integer");
		}
	}
}
