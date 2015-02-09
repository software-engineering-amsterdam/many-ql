package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class QLIdent extends Expr {
	private final String value;
	
	public QLIdent(String value) {
		this.value = value;
	}

	public String show() {
		return this.value;
	}
}
