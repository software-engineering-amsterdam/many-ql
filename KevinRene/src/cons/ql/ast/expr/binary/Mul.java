package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class Mul extends Binary {

	final static String operator = "*";
	
	public Mul(Expr left, Expr right) {
		super(left, right, operator);
	}
}
