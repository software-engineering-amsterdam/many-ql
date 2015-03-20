package qls.gui.widget.input;

import ql.Value;
import qls.gui.widget.InputWidget;
import qls.gui.widget.WidgetStylizer;

public abstract class Field<T extends Value> 
				extends ql.gui.widget.input.Field<T> 
				implements InputWidget<T> {
	protected WidgetStylizer stylizer;
	
	public Field(T initialValue) {
		super(initialValue);
		stylizer = new WidgetStylizer();
	}
}
