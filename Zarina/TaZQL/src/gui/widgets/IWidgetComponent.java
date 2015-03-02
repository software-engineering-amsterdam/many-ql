package gui.widgets;

import interpreter.ValueRepository;

import javax.swing.JComponent;

import ast.type.Type;

public interface IWidgetComponent {
	
	public JComponent getWidget();  // textfield, radio etc.
	public String getIdWidget();	// id
	public Type getWidgetType();	// choice/digits/text
	
	public String getTextValue();			// inserted text (just for testing)
	public boolean getChoiceValue();			// for my check box
	
	public void setValue(String value);
	public void setChoiceValue(boolean value);
	
	public void setEnabled(boolean isEnabled);
	
	public void addDocListener(ValueRepository valRep);
}
