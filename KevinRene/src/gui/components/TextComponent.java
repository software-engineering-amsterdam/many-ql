package gui.components;

import gui.Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import net.miginfocom.swing.MigLayout;
import cons.Value;
import cons.ql.ast.expression.Identifier;
import cons.value.StringValue;

public class TextComponent extends Component implements CaretListener {
	
	protected JPanel container;
	protected JTextField textField;
	protected JLabel errorLabel;
	
	public TextComponent (Identifier identifier, Controller controller) {
		super(identifier, controller);

		textField = new JTextField(100);
    	textField.setMaximumSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.addCaretListener(this);
    	textField.setFocusable(true);
    	
    	errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	container = new JPanel(new MigLayout());
    	container.add(textField);
    	container.add(errorLabel, "wrap");
	}
	
	public TextComponent (Identifier identifier, Controller controller, boolean enabled) {
		this(identifier, controller);
    	textField.setEnabled(false);
	}

	@Override
	public JComponent getComponent() {
		return this.container;
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
	
	protected void setError(String text) {
		textField.setBorder(BorderFactory.createLineBorder(Color.RED));
		errorLabel.setText(text);
	}
	
	protected void removeError() {
		textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		errorLabel.setText("");
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		Value value = new StringValue(textField.getText());	
		
		setChanged();
		
		// Store the new value in the TypeEnvironment
		controller.storeValue(getIdentifier(), value);
		
		// Notify this value has changed
		controller.notify(getIdentifier());
	}
}
