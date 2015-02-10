package cons.ql.ast;

import cons.ql.ast.expr.QLIdent;
import cons.ql.ast.expr.statement.Block;

public class Form extends Expr {
	
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
