package gui.widgets.listeners;

import evaluator.IntegerValue;
import gui.widgets.IWidgetComponent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ast.expression.Expression;

public class IntegerListener extends AListener implements DocumentListener {
	//private final IWidgetComponent widget;
	private int value = 0;
	//private final ValueRepository valueRepository;
//	private EvaluateExpression eval;
	
	public IntegerListener(IWidgetComponent widget,  EvaluateExpression_new evaluator) {//ValueRepository valueRepository) {
		super(widget, evaluator);
		//this.widget = widget;
		//this.valueRepository = valueRepository;
		//eval = new EvaluateExpression(valueRepository);
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		update();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		//update();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		update();
	}
	
	@Override
	public void update() {
		try {
			value = Integer.valueOf(widget.getIntegerValue());
			IntegerValue intValue = new IntegerValue(value);
			//Expression expressionForEvaluation = (Expression) intValue;
			//valueRepository.putID(widget.getIdWidget().toString(), intValue);
			evaluator.setValue(widget.getIdWidget().toString(), intValue);
			
		//	evaluator.evaluate();
			evaluator.setValueInGUI();
			widget.getWidget().revalidate();
			widget.getWidget().repaint();
			
			//System.out.println("Listener value: " + (valueRepository.getValue(widget.getIdWidget())).toString()   );
			
		}
		catch(NumberFormatException ex){
			System.err.println("Ilegal input: digits only!");
		}	
	}
}
