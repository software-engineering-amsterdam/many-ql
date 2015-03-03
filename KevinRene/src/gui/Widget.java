package gui;

import javax.swing.JComponent;

import cons.Value;

@SuppressWarnings("rawtypes")
public interface Widget {
	public void setHandler(Widget handler);
	public void handleChange(Value changedValue);
	
	public void updateComponent();
	public JComponent getComponent();
}
