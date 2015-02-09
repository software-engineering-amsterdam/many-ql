package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class Ident extends Expr {
	private final String value;
	
	public Ident(String value) {
		this.value = value;
	}

	@Override
	public String show() {
		return this.value;
	}
}
