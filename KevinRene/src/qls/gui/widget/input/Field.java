package qls.gui.widget.input;

import ql.Value;
import qls.gui.widget.InputWidget;

public abstract class Field<T extends Value> 
				extends ql.gui.widget.input.Field<T> 
				implements InputWidget<T> {
}
