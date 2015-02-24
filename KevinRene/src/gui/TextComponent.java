package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import cons.ql.ast.expression.Identifier;

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
		super(identifier, controller);
		
		textField = new JTextField(100);
    	textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.setFocusable(true);
    	textField.setEnabled(false);
	}
	
	public JTextField getComponent() {
		return this.textField;
	}
	
	
	public class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			setChanged();
			getController().notify(getIdentifier());
		}

		@Override
		public void keyReleased(KeyEvent e) {}

	}
}
