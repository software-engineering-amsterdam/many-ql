package cons.ql.ast.statement;

import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.statement.Statement;

public class Form extends Statement {
	
	protected QLIdent identifier;
	protected Block block;
	
	public Form(QLIdent identifier, Block statements) {
		this.identifier = identifier;
		this.block = statements;
	}

	public String show() {
		return "Form";
	}
	
	public QLIdent getIdent() {
		return this.identifier;
	}
	
	public Block getBlock() {
		return this.block;
	}
}
