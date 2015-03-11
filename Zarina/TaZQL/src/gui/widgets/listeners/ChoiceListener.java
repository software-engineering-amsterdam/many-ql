package gui.widgets.listeners;

import evaluator.BooleanValue;
import gui.widgets.IWidgetComponent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceListener extends AListener implements ItemListener   {
	
	
	public ChoiceListener(IWidgetComponent widget, EvaluateExpression evaluator) {
		super(widget, evaluator);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			update();
			System.out.println("Selected: " + widget.getBooleanValue());
		}
		else {
			update();
			System.out.println("Unselected: " + widget.getBooleanValue());	
		}
	}

	@Override
	public void update() {
		boolean valueSelected = widget.getBooleanValue();
		BooleanValue boolValue = new BooleanValue(valueSelected);
		evaluator.setValue(widget.getIdWidget().toString(), boolValue);	
		evaluator.setValueInGUI();
	}
	
}