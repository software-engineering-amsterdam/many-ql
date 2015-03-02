package gui.widget;

import gui.Widget;
import cons.Value;

@SuppressWarnings("rawtypes")
public abstract class InputWidget<T extends Value> extends Widget {
	public abstract void disable();
	public abstract T getValue();
	public abstract void setValue(T value);
}
