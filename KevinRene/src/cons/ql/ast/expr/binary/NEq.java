package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class NEq extends Binary {
	final static String operator = "!=";

	public NEq(Expr left, Expr right) {
		super(left, right, operator);
	}
}
