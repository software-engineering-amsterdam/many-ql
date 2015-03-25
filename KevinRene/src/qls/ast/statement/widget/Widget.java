package qls.ast.statement.widget;

import ql.ast.QLType;
import qls.ast.Statement;
import qls.ast.statement.widget.styling.StyleProperties;
import qls.ast.visitor.StatementVisitor;

public class Widget extends Statement {
	private final StyleProperties styleRules;
	private final WidgetType widgetType;
	
	public Widget(WidgetType widgetType) {
		this.styleRules = new StyleProperties();
		this.widgetType = widgetType;
	}
	
	public Widget(StyleProperties styleRules, WidgetType widgetType) {
		this.styleRules = styleRules;
		this.widgetType = widgetType;
	}
	
	public StyleProperties getStyleRules() {
		return styleRules;
	}
	
	public WidgetType getWidgetType() {
		return widgetType;
	}
	
	public boolean isDefault() {
		return widgetType.isDefault();
	}
	
	public boolean isCompatibleWith(QLType type) {
		return widgetType.isCompatibleWith(type);
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Widget";
	}
}
