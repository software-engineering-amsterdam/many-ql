package gui.widget;

import gui.UIComponent;
import ql.Value;


public abstract class InputWidget<T extends Value> extends UIComponent {	
	public abstract void disable();
	
	public abstract void setValue(T value);	
	public abstract T getValue();
}
