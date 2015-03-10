package qls.ast.statement;

import ql.ast.expression.Identifier;
import qls.ast.QLSStatement;
import qls.ast.visitor.QLSStatementVisitor;

public class Stylesheet extends QLSStatement {	
	private final Identifier identifier;
	private final QLSBlock block;

	public Stylesheet(Identifier identifier, QLSBlock block) {
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
	public <T> T accept(QLSStatementVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}