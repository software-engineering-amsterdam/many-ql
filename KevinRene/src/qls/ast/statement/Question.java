package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.Widget;
import qls.ast.visitor.StatementVisitor;
import qls.ast.widget.DefaultWidget;

public class Question extends QLSStatement {
	private final Identifier identifier;
	private Widget widget;
	
	public Question(Identifier identifier) {
		this(identifier, new DefaultWidget());
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
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Question";
	}

}
