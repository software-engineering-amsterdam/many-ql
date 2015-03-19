package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.Statement;
import qls.ast.visitor.StatementVisitor;

public class Stylesheet extends Statement {	
	private final Identifier identifier;
	private final Block pages;

	public Stylesheet(Identifier identifier, Block pages) {
		this.identifier = identifier;
		this.pages = pages;
	}
	
	public Block getPages() {
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