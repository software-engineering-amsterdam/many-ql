package gui;

import javax.swing.JComponent;

import ql.Value;

@SuppressWarnings("rawtypes")
public interface Widget {
	public void setHandler(Widget handler);
	public void handleChange(Value changedValue, Widget source);
	
	public void updateComponent();
	public JComponent getComponent();
}
