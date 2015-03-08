package gui.widgets;

import gui.widgets.listeners.EvaluateExpression;

import javax.swing.JComponent;

import ast.type.Type;

public interface IWidgetComponent {
	
	public JComponent getWidget();  // textfield, radio etc.
	public String getIdWidget();	// id
	public Type getWidgetType();	// choice/digits/text
	
	public String getStringValue();			// inserted text (just for testing)
	public boolean getBooleanValue();			// for my check box
	public int getIntegerValue();
	
	public void setValue(String value);
	public void setChoiceValue(boolean value);
	public void setIntegerValue(int value);
	
	public void setEnabled(boolean isEnabled);
	
	public void addDocListener(); //EvaluateExpression evaluator);
}
