package ql.ast.statement;

import ql.ast.QLType;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.type.QLForm;
import ql.ast.visitor.StatementVisitor;

public class Form extends Statement {
	private final Identifier identifier;
	private final Block block;
	
	public Form(Identifier identifier, Block block) {
		this.identifier = identifier;
		this.block = block;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public QLType getType() {
		return new QLForm();
	}
	
	public Block getBlock() {
		return this.block;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Form(");
		
		sb.append(getIdentifier().toString() + ", ");
		sb.append(getBlock().toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}
