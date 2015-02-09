package cons.ql.ast;

import cons.ql.ast.expr.QLIdent;

public class Form extends Expr {
	
	protected QLIdent identifier;
	protected ASTNode statements;
	
	public Form(QLIdent identifier, ASTNode statements) {
		this.identifier = identifier;
		this.statements = statements;
	}

	public String show() {
		return "Form";
	}
}
