package cons.ql.ast;

import cons.ql.ast.expr.QLIdent;
import cons.ql.ast.expr.statement.Block;

public class Form extends Expr {
	
	protected QLIdent identifier;
	protected Block statements;
	
	public Form(QLIdent identifier, Block statements) {
		this.identifier = identifier;
		this.statements = statements;
	}

	public String show() {
		return "Form " + identifier.show();
	}
}
