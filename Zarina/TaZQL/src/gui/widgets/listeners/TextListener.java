package gui.widgets.listeners;

import evaluator.StringValue;
import gui.widgets.IWidgetComponent;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextListener extends AListener implements DocumentListener {
	
	public TextListener(IWidgetComponent widget, EvaluateExpression evaluator) {
		super(widget, evaluator);
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		update();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		SwingUtilities.invokeLater(new Runnable() {
		     public void run() {
		    	 update();
		     }
		});
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		update();
	}
	
	@Override
	public void update() {
		String value = widget.getValue().toString();
		StringValue intValue = new StringValue(value);
		evaluator.setValue(widget.getIdWidget().toString(), intValue);
	
	}
}
