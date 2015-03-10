package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSVisitor;

public class Page extends QLSStatement {
	private final Identifier identifier;
	private final QLSBlock block;

	public Page(Identifier identifier, QLSBlock block) {
		this.identifier = identifier;
		this.block = block;
	}
	
	public QLSBlock getBlock() {
		return block;
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
		return getIdentifier().toString();
	}
}