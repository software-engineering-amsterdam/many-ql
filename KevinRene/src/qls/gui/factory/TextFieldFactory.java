package qls.gui.factory;

import qls.ast.statement.widget.styling.StyleProperties;
import qls.gui.WidgetBuilder;
import qls.gui.WidgetFactory;
import qls.gui.widget.InputWidget;

public class TextFieldFactory implements WidgetFactory {
	@Override
	public InputWidget<?> create(WidgetBuilder builder, StyleProperties properties) {
		return builder.createTextField(properties);
	}
}
