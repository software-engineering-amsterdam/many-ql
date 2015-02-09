package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class Div extends Binary {
	
	final static String operator = "/";

	public Div(Expr left, Expr right) {
		super(left, right, operator);
	}
}