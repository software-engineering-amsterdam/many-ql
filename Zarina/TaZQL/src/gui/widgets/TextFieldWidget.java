package gui.widgets;

import evaluator.Value;
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
	public String getValue() {
		return widget.getText();
	}
	
	@Override
	public void setValue(String value) {
		value = valueRepository.getValue(id).toString(); 
	}
	
	@Override
	public void setText(Value value) {
		widget.setText("" + value.toString());	
	}
	
	@Override
	public void setEnabled(boolean isEnabled) {
		this.widget.setEnabled(isEnabled);	
	}
	
	@Override
	public void addDocListener(EvaluateExpression evaluator) {
		widget.getDocument().addDocumentListener(new TextListener(this, evaluator));
	}

	@Override
	public boolean getBooleanValue() {
		assert false: "Can't be used in TextField.";
		return false;
	}

	@Override
	public void setBooleanValue(boolean value) {
		assert false: "Can't be used for text widget, only for checkbox widget.";
	}
}