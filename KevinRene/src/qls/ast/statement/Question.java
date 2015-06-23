package qls.ast.statement;

import ql.ast.QLType;
import ql.ast.expression.Identifier;
import qls.ast.Statement;
import qls.ast.statement.widget.Widget;
import qls.ast.statement.widget.type.Default;
import qls.ast.visitor.StatementVisitor;

public class Question extends Statement {
	private final Identifier identifier;
	private Widget widget;
	
	public Question(Identifier identifier) {
		this(identifier, new Widget(new Default()));
	}
	
	public Question(Identifier identifier, Widget widget) {
		this.identifier = identifier;
		this.widget = widget;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	public Widget getWidget() {
		return widget;
	}
	
	public boolean hasDefaultWidget() {
		return widget.isDefault();
	}
	
	public boolean hasCompatibleWidget(QLType type) {
		return widget.isCompatibleWith(type);
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Question";
	}
}
