package qls.ast.statement.widget;

import qls.ast.QLSStatement;
import qls.ast.statement.styling.StyleRuleSet;
import qls.ast.visitor.StatementVisitor;

public class Widget extends QLSStatement {
	private final StyleRuleSet styleRules;
	private final WidgetType widgetType;
	
	public Widget(WidgetType widgetType) {
		this.styleRules = new StyleRuleSet();
		this.widgetType = widgetType;
	}
	
	public Widget(StyleRuleSet styleRules, WidgetType widgetType) {
		this.styleRules = styleRules;
		this.widgetType = widgetType;
	}
	
	public StyleRuleSet getStyleRules() {
		return styleRules;
	}
	
	public WidgetType getWidgetType() {
		return widgetType;
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
