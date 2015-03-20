package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.Statement;
import qls.ast.visitor.StatementVisitor;

public class Page extends Statement {
	private final Identifier identifier;
	private final Block statements;

	public Page(Identifier identifier, Block statements) {
		this.identifier = identifier;
		this.statements = statements;
	}
	
	public Block getStatements() {
		return statements;
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
		return "Page " + getIdentifier().toString();
	}
}