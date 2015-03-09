package qls.ast.statement;

import qls.ast.Identifier;
import qls.ast.Statement;
import qls.ast.visitor.Visitor;

public class Stylesheet extends Statement {
	
	private final Identifier identifier;
	private final Block block;

	public Stylesheet(Identifier identifier, Block block) {
		this.identifier = identifier;
		this.block = block;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}