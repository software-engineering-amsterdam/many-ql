package gui.widget;

import ql.Value;
import gui.Widget;

@SuppressWarnings("rawtypes")
public abstract class InputWidget<T extends Value> implements Widget {
	private Widget handler;
	
	public abstract void disable();
	
	public abstract void setValue(T value);
	public abstract T getValue();
	
	@Override
	public void setHandler(Widget handler) {
		this.handler = handler;
	}
	
	@Override
	public void handleChange(Value changedValue, Widget source) {
		handler.handleChange(changedValue, source);
	}
}
