package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class MyKeyListener implements KeyListener {
	
	private JTextField textField;
	
	public MyKeyListener(JTextField textField) {
		this.textField = textField;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println(textField.getText());
			System.out.println("lol");
		}
		System.out.println("lol");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("lol1");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("lol2");
	}

}
