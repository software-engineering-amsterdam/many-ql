package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

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
    	textField.addKeyListener(new MyKeyListener());
    	textField.setFocusable(true);
	}
	
	public TextComponent (Identifier identifier, Controller controller, boolean enabled) {
		this(identifier, controller);
    	textField.setEnabled(false);
	}
	
	public JTextField getComponent() {
		return this.textField;
	}
	
	public class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			Value value = new StringValue(textField.getText());			
			setChanged();
			
			System.out.println("new value for " + getIdentifier() + ": " + value);
			
			// Update the type environment
			getController().storeValue(getIdentifier(), value);
			
			// Now update all the Components that watch the computedQuestion
			getController().notify(getIdentifier());
			
			
//			getController().notify(getIdentifier());
//			notifyObservers();
		}

		@Override
		public void keyReleased(KeyEvent e) {}
	}


	@Override
	public void setValue(Value value) {
		// Update value of the JComponent
		textField.setText(value.toString());
		setChanged();
		
		// Store the new value in the TypeEnvironment
		controller.storeValue(getIdentifier(), value);
		
		// Notify this value has changed
		controller.notify(getIdentifier());
	}
}
