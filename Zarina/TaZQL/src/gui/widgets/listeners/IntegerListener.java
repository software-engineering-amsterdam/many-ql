package gui.widgets.listeners;

import gui.widgets.IWidgetComponent;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class IntegerListener extends AListener implements DocumentListener {
	
	public IntegerListener(IWidgetComponent widget,  EvaluateExpression evaluator) {
		super(widget, evaluator);
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		update();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
	    update();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		update();
	}


	@Override
	public void update() {		
		evaluator.setValue(widget.getIdWidget().toString(), widget.getValue());
			
		SwingUtilities.invokeLater(new Runnable() {
			@Override
				public void run() {
					evaluator.setValueInGUI();
				}
		}); 
	}
}

