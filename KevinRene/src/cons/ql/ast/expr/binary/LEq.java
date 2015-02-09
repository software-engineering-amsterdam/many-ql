package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class LEq extends Binary {
	
	final static String operator = "<=";

	public LEq(Expr left, Expr right) {
		super(left, right, operator);
	}
}
