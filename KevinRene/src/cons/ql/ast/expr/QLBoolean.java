package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class QLBoolean extends Expr {
	
	private String value;
		
	public QLBoolean(String value) {
		this.value = value;
	}

	@Override
	public String show() {
		return value;
	}
}
