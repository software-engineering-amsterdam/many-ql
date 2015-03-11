package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.Widget;
import qls.ast.visitor.QLSVisitor;

public class Question extends QLSStatement {
	private final Identifier identifier;
	private Widget widget;
	
	public Question(Identifier identifier) {
		this.identifier = identifier;
	}
	
	public Question(Identifier identifier, Widget widget) {
		this.identifier = identifier;
		this.widget = widget;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Question";
	}

}
