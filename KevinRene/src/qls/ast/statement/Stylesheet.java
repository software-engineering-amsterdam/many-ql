package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.visitor.StatementVisitor;

public class Stylesheet extends QLSStatement {	
	private final Identifier identifier;
	private final QLSBlock pages;

	public Stylesheet(Identifier identifier, QLSBlock pages) {
		this.identifier = identifier;
		this.pages = pages;
	}
	
	public QLSBlock getPages() {
		return pages;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Stylesheet";
	}
}