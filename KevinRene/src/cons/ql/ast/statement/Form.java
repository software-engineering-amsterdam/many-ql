package cons.ql.ast.statement;

import java.util.Arrays;

import cons.ql.ast.Statement;
import cons.ql.ast.expression.literal.QLIdent;

public class Form extends Statement {
	private final int IDENTIFIER = 0;
	private final int BLOCK = 1;
	
	public Form(QLIdent identifier, Block block) {
		this.members.addAll(Arrays.asList(identifier, block));
	}
	
	public QLIdent getIdent() {
		return (QLIdent) this.members.get(IDENTIFIER);
	}
	
	public Block getBlock() {
		return (Block) this.members.get(BLOCK);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Form(");
		
		sb.append(getIdent().toString() + ", ");
		sb.append(getBlock().toString());
		sb.append(")");
		
		return sb.toString();
	}
}
