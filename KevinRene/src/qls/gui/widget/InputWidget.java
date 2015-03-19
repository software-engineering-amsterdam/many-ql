package qls.gui.widget;

import ql.Value;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.statement.widget.styling.property.Font;

public interface InputWidget<T extends Value> extends ql.gui.widget.InputWidget<T> {	
	public void setStyle(StyleProperties properties);
	public void setFont(Font font);
}
