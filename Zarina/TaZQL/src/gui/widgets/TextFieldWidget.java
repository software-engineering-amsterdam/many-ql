package gui.widgets;

import interpreter.ValueRepository;

import javax.swing.JComponent;
import javax.swing.JTextField;

import ast.type.Type;


public class TextFieldWidget implements IWidgetComponent {
	private final String id; 
	private final Type variableType;
	private JTextField widget;
		
	public TextFieldWidget(String id, String label, Type variableType) {
		this.id = id;
		this.variableType = variableType;
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
	public void addDocListener(ValueRepository valRep) {
		widget.getDocument().addDocumentListener(new TextDigitsListener(this, valRep));
	}

	@Override
	public String getTextValue() {
		return widget.getText();
	}

	@Override
	public boolean getChoiceValue() {
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

}