package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class Or extends Binary {

	final static String operator = "||";

	public Or(Expr left, Expr right) {
		super(left, right, operator);
	}
}
