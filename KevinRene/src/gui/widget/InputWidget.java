package gui.widget;

import gui.Widget;
import cons.Value;

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
	public void handleChange(Value changedValue) {
		handler.handleChange(changedValue);
	}
}
