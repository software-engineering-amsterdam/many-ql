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
	    	 update();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		update();
	}
	
	@Override
	public void update() {
		String regex ="[-+]?\\d+(\\.\\d+)?";
		if(widget.getValue().trim().matches(regex)) {
			System.out.println("Check of match: " + widget.getValue().trim().matches(regex));
			Integer value = Integer.valueOf(widget.getValue().trim());
			IntegerValue intValue = new IntegerValue(value);
			System.out.println("Integer: " + value);
			
			evaluator.setValue(widget.getIdWidget().toString(), intValue);
			 SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		            	evaluator.setValueInGUI();
		            }
			 });
		}
		else { 
			System.out.println("Illegal input: digits only!" + " Probably in: " + widget.getIdWidget().toString());
			//TODO add some error display
		}
	} 
}
