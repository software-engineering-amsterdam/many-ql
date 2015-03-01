package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.math.BigInteger;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import cons.Value;
import cons.ql.ast.expression.Identifier;
import cons.value.IntegerValue;

public class IntegerComponent extends Component {

	private JPanel container;
	private JTextField textField;
	private JLabel errorLabel;
	
	public IntegerComponent (Identifier identifier, Controller controller) {
		super(identifier, controller);
		
		textField = new JTextField(100);
    	textField.setMaximumSize(new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.addCaretListener(new MyCaretListener());
    	textField.setFocusable(true);
    	
    	errorLabel = new JLabel();
    	errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
    	errorLabel.setVisible(true);
    	
    	container = new JPanel();
    	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    	container.add(textField);
    	container.add(Box.createRigidArea(new Dimension(10,0)));
    	container.add(errorLabel);
	}
	
	public IntegerComponent (Identifier identifier, Controller controller, boolean enabled) {
		this(identifier, controller);
    	textField.setEnabled(false);
	}
	
	@Override
	public JComponent getComponent() {
		return this.container; //this.textField;
	}
	
	public class MyCaretListener implements CaretListener {

		@Override
		public void caretUpdate(CaretEvent e) {
			try {
				Value value = new IntegerValue(Integer.parseInt(textField.getText()));			
				
				System.out.println("Set value for " + getIdentifier() + " to " + value);
				
				setChanged();
				
				// Store the new value in the TypeEnvironment
				controller.storeValue(getIdentifier(), value);
				
				// Notify this value has changed
				controller.notify(getIdentifier());

				textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				errorLabel.setVisible(false);
			}
			catch (NumberFormatException nfe) {
				System.err.println(nfe);
				
				textField.setBorder(BorderFactory.createLineBorder(Color.RED));
				errorLabel.setText("Not an integer");
				errorLabel.setVisible(true);
			}
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
}
