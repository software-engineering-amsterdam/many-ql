package ql.gui.widget;

import ql.Value;
import ql.gui.Component;


public interface InputWidget<T extends Value> extends Component {	
	public void disable();

	public void setValue(T value);	
	public T getValue();
}
