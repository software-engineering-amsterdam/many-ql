package qls.ast.statement;

import qls.ast.Statement;
import qls.ast.visitor.StatementVisitor;
import qls.ast.expression.literal.StringLiteral;

public class Section extends Statement {
	private final StringLiteral header;
	private final Block statements;
	
	public Section(StringLiteral header, Block statements) {
		this.header = header;
		this.statements = statements;
	}
	
	public StringLiteral getHeader() {
		return header;
	}
	
	public Block getStatements() {
		return statements;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Section " + getHeader().toString();
	}
}