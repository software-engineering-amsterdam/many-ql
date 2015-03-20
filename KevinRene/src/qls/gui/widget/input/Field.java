package qls.gui.widget.input;

import ql.Value;
import qls.ast.statement.widget.styling.property.Font;
import qls.gui.widget.InputWidget;

public abstract class Field<T extends Value> 
				extends ql.gui.widget.input.Field<T> 
				implements InputWidget<T> {
	
	public Field(T initialValue) {
		super(initialValue);
	}

	protected abstract void setFont(Font font);
}
