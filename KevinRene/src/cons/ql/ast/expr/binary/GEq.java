package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class GEq extends Binary {

	final static String operator = ">=";

	public GEq(Expr left, Expr right) {
		super(left, right, operator);
	}
}
