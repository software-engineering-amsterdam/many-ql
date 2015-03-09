package gui.widgets;

import evaluator.ValueRepository;
import gui.widgets.listeners.EvaluateExpression;
import gui.widgets.listeners.TextListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.Type;


public class TextFieldWidget implements IWidgetComponent {
	private final String id; 
	private final Type variableType;
	private JTextField widget;
	private final ValueRepository valueRepository;
		
	public TextFieldWidget(String id, String label, Type variableType, ValueRepository valueRepository) {
		this.id = id;
		this.variableType = variableType;
		this.valueRepository = valueRepository;
		this.widget = new JTextField("", 10);
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
	public Type getWidgetType(){
		return this.variableType;
	}
	
	@Override
	public void addDocListener() { //EvaluateExpression evaluator) {
		widget.getDocument().addDocumentListener(new TextListener(this, valueRepository));
	}

	@Override
	public String getStringValue() {
		return widget.getText();
	}

	@Override
	public boolean getBooleanValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
		value = widget.getText();
		
	}

	@Override
	public void setChoiceValue(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIntegerValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setIntegerValue(int value) {
		// TODO Auto-generated method stub
		
	}

}