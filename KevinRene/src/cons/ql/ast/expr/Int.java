package cons.ql.ast.expr;

import cons.ql.ast.Expr;

public class Int extends Expr {
	
	private int value;
		
	public Int(int value) {
		this.value = value;
	}

	@Override
	public String show() {
		return String.valueOf(value);
	}
}
