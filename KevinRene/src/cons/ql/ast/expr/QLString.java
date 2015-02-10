package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class QLString extends Expr {
	
	private String value;
		
	public QLString(String value) {
		this.value = value;
	}

	@Override
	public String show() {
		return value;
	}
}
