package qls.gui;

import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.widget.InputWidget;

public interface WidgetFactory {
	public InputWidget<?> create(WidgetBuilder builder, StyleProperties properties);
}
