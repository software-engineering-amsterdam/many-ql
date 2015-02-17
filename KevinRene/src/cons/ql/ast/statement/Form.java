package cons.ql.ast.statement;

import cons.Register;
import cons.ql.ast.Statement;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.visitor.Visitor;

public class Form extends Statement {
	private final Identifier identifier;
	private final Block block;
	
	public Form(Identifier identifier, Block block) {
		this.identifier = identifier;
		this.block = block;
		
		Register.getInstance().store(this.identifier, this);
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
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
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
