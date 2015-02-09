package cons.ql.ast.expr.binary;

import cons.ql.ast.Binary;
import cons.ql.ast.Expr;

public class And extends Binary {


	final static String operator = "&&";
	
	public And(Expr left, Expr right) {
		super(left, right, operator);
	}
}
