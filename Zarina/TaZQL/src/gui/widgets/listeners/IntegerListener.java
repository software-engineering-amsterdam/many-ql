package gui.widgets.listeners;

import evaluator.IntegerValue;
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
		try {
			int value = Integer.valueOf(widget.getValue());
			IntegerValue intValue = new IntegerValue(value);
			evaluator.setValue(widget.getIdWidget().toString(), intValue);
			System.out.println("Integer: " + value);
			evaluator.setValueInGUI();	
			
		}
		catch(NumberFormatException ex){
			//System.err.println("Ilegal input: digits only!");
			//ex.printStackTrace();
			//TODO solve this horror
		}	
	} 	
}
