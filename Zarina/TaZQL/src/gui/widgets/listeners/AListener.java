package gui.widgets.listeners;

import evaluator.ValueRepository;
import gui.widgets.IWidgetComponent;

public abstract class AListener {
	protected final IWidgetComponent widget;
	protected final ValueRepository valueRepository;
	
	public AListener(IWidgetComponent widget, ValueRepository valueRepository) {
		this.widget = widget;
		this.valueRepository = valueRepository;
	}
	
	public abstract void update();
}

