package ql.gui;

import ql.Value;

public abstract class DefaultComponent implements Component {
	private Component handler;
	
	@Override
	public void setHandler(Component handler) {
		this.handler = handler;
	}
	
	@Override
	public void handleChange(Value changedValue, Component source) {
		handler.handleChange(changedValue, source);
	}
}
