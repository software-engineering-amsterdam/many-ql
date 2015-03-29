package ql.gui;

import javax.swing.JComponent;

import ql.Value;

public interface Component {
	public void setHandler(Component handler);
	public void handleChange(Value changedValue, Component source);
	
	public void updateComponent();
	public JComponent getComponent();
}
