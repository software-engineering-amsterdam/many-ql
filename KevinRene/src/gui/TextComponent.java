package gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import cons.Value;
import cons.ql.ast.expression.Identifier;
import cons.value.StringValue;

public class TextComponent extends Component {
	
	private JTextField textField;
	
	public TextComponent (Identifier identifier, Controller controller) {
		super(identifier, controller);
		
		textField = new JTextField(100);
    	textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.addCaretListener(new MyCaretListener());
    	textField.setFocusable(true);
	}
	
	public TextComponent (Identifier identifier, Controller controller, boolean enabled) {
		this(identifier, controller);
    	textField.setEnabled(false);
	}
	
	public class MyCaretListener implements CaretListener {
		@Override
		public void caretUpdate(CaretEvent e) {
			Value value = new StringValue(textField.getText());			
			
			System.out.println("Set value for " + getIdentifier() + " to " + value);
			
			setChanged();
			
			// Store the new value in the TypeEnvironment
			controller.storeValue(getIdentifier(), value);
			
			// Notify this value has changed
			controller.notify(getIdentifier());
		}
	}


	@Override
	public void setValue(Value value) {
		
		System.out.println("Set value for " + getIdentifier() + " to " + value);
		
		// Update value of the JComponent
		textField.setText(value.toString());
		setChanged();
		
		// Store the new value in the TypeEnvironment
		controller.storeValue(getIdentifier(), value);
		
		// Notify this value has changed
		controller.notify(getIdentifier());
	}

	@Override
	public JComponent getComponent() {
		return this.textField;
	}
}
