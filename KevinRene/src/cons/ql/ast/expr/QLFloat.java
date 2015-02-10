package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class QLFloat extends Expr {
	
	private int value;
		
	public QLFloat(int value) {
		this.value = value;
	}

	@Override
	public String show() {
		return String.valueOf(value);
	}
}
