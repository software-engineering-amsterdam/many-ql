package gui.widgets;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextDigitsListener implements DocumentListener {
	private final IWidgetComponent widget;
	
	public TextDigitsListener(IWidgetComponent widget) {
		this.widget = widget;
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		//wc.getValue();
		printOut();
		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		printOut();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		// TODO Auto-generated method stub
		printOut();
	}
	
	public void printOut() {
		widget.setValue(widget.getValue());
		System.out.print("Listener: " + widget.getValue());
	}

}
