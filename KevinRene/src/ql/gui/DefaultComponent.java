package ql.gui;

import ql.Value;

public abstract class DefaultComponent implements UIComponent {
	private UIComponent handler;
	
	@Override
	public void setHandler(UIComponent handler) {
		this.handler = handler;
	}
	
	@Override
	public void handleChange(Value changedValue, UIComponent source) {
		handler.handleChange(changedValue, source);
	}
}
