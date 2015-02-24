package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import cons.ql.ast.expression.Identifier;

public class TextComponent extends Component {
	
	private JTextField textField;
	
	public TextComponent (Identifier identifier, Controller controller, Container pane) {
		super(identifier, controller);
		
		textField = new JTextField(100);
    	textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height * 2));
    	textField.setFont(new Font("Serif", Font.BOLD, 20));
    	textField.addKeyListener(new MyKeyListener());
    	textField.setFocusable(true);
    	pane.add(textField);
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
