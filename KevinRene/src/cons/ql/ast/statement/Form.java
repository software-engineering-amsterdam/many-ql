package cons.ql.ast.statement;

import cons.ql.ast.Statement;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.literal.QLIdent;

public class Form extends Statement {	
	protected QLIdent identifier;
	protected Block block;
	
	public Form(QLIdent identifier, Block statements) {
		this.identifier = identifier;
		this.block = statements;
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	
	public Block getBlock() {
		return this.block;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Form(");
		
		sb.append(identifier.toString() + ", ");
		sb.append(block.toString());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public void accept(Visitor visitor) {
		identifier.accept(visitor);
		block.accept(visitor);
		
		visitor.visit(this);		
	}
}
