package ql.gui.widget;

import ql.Value;
import ql.gui.UIComponent;


public interface InputWidget<T extends Value> extends UIComponent {	
	public void disable();

	public void setValue(T value);	
	public T getValue();
}
