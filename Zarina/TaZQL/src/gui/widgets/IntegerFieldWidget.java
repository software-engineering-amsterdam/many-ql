package gui.widgets;

import evaluator.ValueRepository;
import gui.widgets.listeners.EvaluateExpression;
import gui.widgets.listeners.IntegerListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.Type;

public class IntegerFieldWidget implements IWidgetComponent {

	private final String id; 
	private final Type variableType;
	private JTextField widget;
	private final ValueRepository valueRepository;
	private int value = 0;
		
	public IntegerFieldWidget(String id, String label, Type variableType, ValueRepository valueRepository) {
		this.id = id;
		this.variableType = variableType;
		this.valueRepository = valueRepository;
		this.widget = new JTextField("0", 10);
		
	}
	
	@Override
	public JComponent getWidget() {
		return this.widget;
	}

	@Override
	public String getIdWidget() {
		return this.id;
	}

	@Override
	public Type getWidgetType() {
		return variableType;
	}

	@Override
	public String getStringValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBooleanValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setChoiceValue(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		this.widget.setEnabled(isEnabled);
		
	}

	@Override
	public void addDocListener() {//EvaluateExpression evaluator) {
		widget.getDocument().addDocumentListener(new IntegerListener(this, valueRepository));
	}

	@Override
	public int getIntegerValue() {
		//return Integer.valueOf(widget.getText());
		return value + Integer.valueOf(widget.getText());
	}

	@Override
	public void setIntegerValue(int value) {
		this.value = value + Integer.parseInt(valueRepository.getValue(id).toString());
		
	}
}
