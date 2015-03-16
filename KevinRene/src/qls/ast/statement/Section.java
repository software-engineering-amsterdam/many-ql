package qls.ast.statement;

import ql.ast.expression.literal.StringLiteral;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSVisitor;

public class Section extends QLSStatement {
	private final StringLiteral header;
	private final QLSBlock statements;
	
	public Section(StringLiteral header, QLSBlock statements) {
		this.header = header;
		this.statements = statements;
	}
	
	public StringLiteral getHeader() {
		return header;
	}
	
	public QLSBlock getStatements() {
		return statements;
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Section " + getHeader().toString();
	}
}