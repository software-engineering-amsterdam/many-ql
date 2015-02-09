package cons.ql.ast.expr.unary;

import cons.ql.ast.Expr;
import cons.ql.ast.Unary;

public class Neg extends Unary {

	final static String operator = "-";
	
	public Neg(Expr operand) {
		super(operand, operator);
	}
}
