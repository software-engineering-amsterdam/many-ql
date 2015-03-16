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
		if(isInteger()) {
		
			int value = Integer.valueOf(widget.getValue().trim());
			IntegerValue intValue = new IntegerValue(value);
			System.out.println("Integer: " + intValue + " | id " + widget.getIdWidget());
			
			evaluator.setValue(widget.getIdWidget().toString(), intValue);
			
			SwingUtilities.invokeLater(new Runnable() {
		            @Override
		            public void run() {
		            	evaluator.setValueInGUI();
		            }
			 });
		      	
		}
		else if (isEmptyEntry()) {
			IntegerValue intValue = new IntegerValue(0);
			System.out.println("Empty integer: " + intValue + " for " + widget.getIdWidget().toString());
			
			evaluator.setValue(widget.getIdWidget().toString(), intValue);
			
		}
		else { 
			System.out.println("Illegal input: digits only!" + " Probably in: " + widget.getIdWidget().toString());
			//TODO add some error display 
		}
	}
	
	public boolean isInteger() {
		String regexDigits ="[-+]?\\d+(\\.\\d+)?";
		String valueToCheck = widget.getValue().trim();
		
		boolean checkIfInteger = valueToCheck.matches(regexDigits);
		System.out.println("Listener. Is integer: " + widget.getValue().trim().matches(regexDigits) + " for " + widget.getIdWidget());
		
		return checkIfInteger;
	}
	
	public boolean isEmptyEntry() {
		String valueToCheck = widget.getValue().trim();
		boolean emptyEntryCheck = valueToCheck.isEmpty();
		
		return emptyEntryCheck;
	}
}
