package gui.widgets.listeners;

import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

public abstract class AListener {
	protected final IWidgetComponent widget;
	//protected final ValueRepository valueRepository;
	protected final EvaluateExpression evaluator;
	
	public AListener(IWidgetComponent widget, EvaluateExpression evaluator) { //ValueRepository valueRepository) {
		this.widget = widget;
		this.evaluator = evaluator;
	//	this.valueRepository = valueRepository;
	}
	
	public abstract void update();
}

