package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class Eq extends Binary {

	final static String operator = "==";
	
	public Eq(Expr left, Expr right) {
		super(left, right, operator);
	}

}
