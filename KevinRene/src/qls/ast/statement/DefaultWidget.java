package qls.ast.statement;

import ql.ast.QLType;
import qls.ast.Statement;
import qls.ast.statement.widget.Widget;
import qls.ast.visitor.StatementVisitor;

public class DefaultWidget extends Statement {	
	private final QLType type;
	private final Widget widget;
	
	public DefaultWidget(QLType type, Widget widget) {
		this.type = type;
		this.widget = widget;
	}
	
	public QLType getType() {
		return type;
	}
	
	public Widget getWidget() {
		return widget;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "DefaultWidget";
	}

}
