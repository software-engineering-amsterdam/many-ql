package cons.ql.ast.expr.unary;

import cons.ql.ast.Expr;
import cons.ql.ast.Unary;

public class Not extends Unary {

	final static String operator = "!";
	
	public Not(Expr operand) {
		super(operand, operator);
	}
}
