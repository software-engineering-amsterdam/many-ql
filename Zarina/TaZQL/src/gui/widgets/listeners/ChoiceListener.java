package gui.widgets.listeners;

import gui.widgets.IWidgetComponent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceListener extends AListener implements ItemListener   {
	
	
	public ChoiceListener(IWidgetComponent widget, EvaluateExpression evaluator) {
		super(widget, evaluator);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			update();
		}
		else {
			update();
		}
	}

	@Override
	public void update() {
		evaluator.setValue(widget.getIdWidget().toString(), widget.getValue());	
		evaluator.setVisibilityInGUI();
	}
	
}