package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class QLInt extends Expr {	
	private int value;
		
	public QLInt(int value) {
		this.value = value;
	}

	public String show() {
		return String.valueOf(value);
	}
}
