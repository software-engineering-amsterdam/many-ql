package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class Add extends Binary {

	final static String operator = "+";
	
	public Add(Expr left, Expr right) {
		super(left, right, operator);
	}
}
