package gui.widgets;

import javax.swing.JComponent;

import ast.type.Type;
import evaluator.Value;
import gui.listeners.EvaluateExpression;

public interface IWidgetComponent {
	
	public JComponent getWidget();  
	public String getIdWidget();	
	public Type getWidgetType();	
	
	public void setEnabled(boolean isEnabled);	
	public void addDocListener(EvaluateExpression evaluator);
	
	public Value getValue();
	public void setValue(Value value);	
	
	public void setVisible(boolean visibility);
}
