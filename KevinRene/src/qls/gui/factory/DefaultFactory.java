package qls.gui.factory;

import ql.ast.QLType;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.visitor.widgetbinder.DefaultWidgetEnvironment;
import qls.gui.WidgetBuilder;
import qls.gui.WidgetFactory;
import qls.gui.widget.InputWidget;

public class DefaultFactory implements WidgetFactory {
	private DefaultWidgetEnvironment defaultWidgets;
	
	public DefaultFactory(DefaultWidgetEnvironment defaultWidgets) {
		this.defaultWidgets = defaultWidgets;
	}
	
	@Override
	public InputWidget<?> create(WidgetBuilder builder, StyleProperties properties) {
		QLType builderType = builder.getBuilderType();
		
		return defaultWidgets.resolve(builderType);
	}
}
