package qls.ast.statement;

import ql.ast.expression.literal.StringLiteral;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSVisitor;

public class Section extends QLSStatement {
	private final StringLiteral header;
	private final QLSBlock block;
	
	public Section(StringLiteral header, QLSBlock block) {
		this.header = header;
		this.block = block;
	}
	
	public StringLiteral getHeader() {
		return header;
	}
	
	public QLSBlock getBlock() {
		return block;
	}
	
	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return getHeader().toString();
	}
}