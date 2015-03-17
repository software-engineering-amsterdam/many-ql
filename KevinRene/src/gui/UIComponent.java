package gui;

import javax.swing.JComponent;

import ql.Value;

public abstract class UIComponent {
	private UIComponent handler;
	
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}
	
	public void handleChange(Value changedValue, UIComponent source) {
		handler.handleChange(changedValue, source);
	}
	
	public abstract void updateComponent();
	public abstract JComponent getComponent();
}
