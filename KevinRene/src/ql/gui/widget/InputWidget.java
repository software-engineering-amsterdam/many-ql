package ql.gui.widget;

import ql.Value;
import ql.gui.UIComponent;

public abstract class InputWidget<T extends Value> extends UIComponent {
	public abstract void disable();

	public abstract void setValue(T value);

	public abstract T getValue();
}
