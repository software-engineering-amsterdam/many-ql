package gui.widgets;

import javax.swing.JComponent;

import ast.type.Type;
import evaluator.Value;
import gui.widgets.listeners.EvaluateExpression;

public interface IWidgetComponent {
	
	public JComponent getWidget();  
	public String getIdWidget();	
	public Type getWidgetType();	
	
	public void setEnabled(boolean isEnabled);	
	public void addDocListener(EvaluateExpression evaluator);
	public void setText(Value value);
	
	public boolean getBooleanValue();			
	public String getValue();
	
	public void setBooleanValue(boolean value);
	public void setValue(String value);	
	
	public void setVisible(boolean visibility);
}
