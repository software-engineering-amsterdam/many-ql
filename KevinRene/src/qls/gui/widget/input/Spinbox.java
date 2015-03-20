package qls.gui.widget.input;

import javax.swing.SpinnerNumberModel;

import ql.Value;
import qls.ast.statement.widget.styling.property.Font;
import qls.gui.widget.InputWidget;

public abstract class Spinbox<T extends Value> 
				extends ql.gui.widget.input.Spinbox<T> 
				implements InputWidget<T> {
	public Spinbox(SpinnerNumberModel model) {
		super(model);
	}
	
	protected abstract void setFont(Font font);
}
