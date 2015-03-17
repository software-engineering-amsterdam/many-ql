package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.visitor.StatementVisitor;

public class Page extends QLSStatement {
	private final Identifier identifier;
	private final QLSBlock statements;

	public Page(Identifier identifier, QLSBlock statements) {
		this.identifier = identifier;
		this.statements = statements;
	}
	
	public QLSBlock getStatements() {
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