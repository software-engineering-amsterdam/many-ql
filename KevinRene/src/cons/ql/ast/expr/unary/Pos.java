package cons.ql.ast.expr.unary;

import cons.ql.ast.Expr;
import cons.ql.ast.Unary;

public class Pos extends Unary {

	final static String operator = "+";
	
	public Pos(Expr operand) {
		super(operand, operator);
	}
}
