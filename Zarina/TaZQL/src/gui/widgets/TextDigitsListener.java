package gui.widgets;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextDigitsListener implements DocumentListener {
	private final JTextField widget;
	
	public TextDigitsListener(JTextField widget) {
		this.widget = widget;
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		//wc.getValue();
		System.out.print("Listener: " + widget.getText());
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("Listener: " + widget.getText());
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		System.out.print("Listener: " + widget.getText());
		
	}

}
