package ql.gui;

import javax.swing.JComponent;

import ql.Value;

public interface UIComponent {
	public void setHandler(UIComponent handler);
	public void handleChange(Value changedValue, UIComponent source);
	
	public void updateComponent();
	public JComponent getComponent();
}
