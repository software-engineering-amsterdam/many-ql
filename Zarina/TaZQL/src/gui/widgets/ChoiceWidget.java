package gui.widgets;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.type.Type;
import evaluator.BooleanValue;
import evaluator.Value;
import evaluator.ValueRepository;
import gui.widgets.listeners.ChoiceListener;
import gui.widgets.listeners.EvaluateExpression;

public class ChoiceWidget implements IWidgetComponent {
	private final String id, label;
	private final Type widgetType;
	private JCheckBox widget;
	private final ValueRepository valueRepository;
		
	public ChoiceWidget(String id, String label, Type widgetType, ValueRepository valueRepository) {
		this.id = id;
		this.label = label;
		this.valueRepository = valueRepository;
		this.widgetType = widgetType;
		this.widget = new JCheckBox();
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public String getIdWidget() {
		return id;
	}

	@Override
	public Type getWidgetType() {
		return widgetType;
	}


	@Override
	public void addDocListener(EvaluateExpression evaluator) {
		widget.addItemListener(new ChoiceListener(this, evaluator));
		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		// not necessary
	}

	
	@Override
	public Value getValue() {
		return new BooleanValue(widget.isSelected());
	}

	@Override
	public void setValue(Value value) {
		boolean selected = (Boolean) value.getValue();
		
		this.widget.setSelected(selected);
	}
	
	@Override
	public void setVisible(boolean visibility) {
		widget.setVisible(visibility);
	}
}
