package cons.ql.ast.expr.statement;

import cons.ql.ast.Expr;
import cons.ql.ast.expr.QLIdent;
import cons.ql.ast.expr.QLString;
import cons.ql.ast.expr.QLType;

public class Assignment extends Question {
	
	private Expr expr;
	
	public Assignment(QLIdent identifier, QLType type, QLString text, Expr expr) {
		super(identifier, type, text);
		this.expr = expr;
	}

	@Override
	public String show() {
		return "Assignment";
	}
	
	public Expr getExpr() {
		return this.expr;
	}
}
