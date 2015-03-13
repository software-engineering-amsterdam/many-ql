package gui.widgets;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import ast.type.Type;
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
	public boolean getBooleanValue() {
		return widget.isSelected();
	}

	
	@Override
	public void setBooleanValue(boolean value) {
		this.widget.setSelected(value);
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
	public void setText(Value value) {
		widget.setText("");
	}
	
	@Override
	public String getValue() {
		assert false: "Not supported in Checkbox, only for textfields.";
		return null;
	}

	@Override
	public void setValue(String value) {
		assert false: "Not supported in Checkbox, only for textfields.";
	}
	
	@Override
	public void setVisible(boolean visibility) {
		widget.setVisible(visibility);
	}
}
