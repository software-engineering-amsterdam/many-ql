package qls.ast.statement;

import ql.ast.QLType;
import qls.ast.QLSStatement;
import qls.ast.Widget;
import qls.ast.stylerule.StyleRuleSet;
import qls.ast.visitor.QLSVisitor;
import qls.ast.widget.DefaultWidget;

public class Default extends QLSStatement {	
	private final QLType type;
	private final Widget widget;
	private final StyleRuleSet ruleSet;
	
	public Default(QLType type, Widget widget) {
		this(type, new StyleRuleSet(), widget);
	}
	
	public Default (QLType type, StyleRuleSet ruleSet) {
		this(type, ruleSet, new DefaultWidget());
	}
	
	public Default (QLType type, StyleRuleSet ruleSet, Widget widget) {
		this.type = type;
		this.widget = widget;
		this.ruleSet = ruleSet;
	}
	
	public QLType getType() {
		return type;
	}
	
	public Widget getWidget() {
		return widget;
	}
	
	public StyleRuleSet getStyleRuleSet() {
		return ruleSet;
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Default";
	}

}
