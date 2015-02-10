package cons.ql.ast.expression.unary;

import cons.ql.ast.expression.Expression;
import cons.ql.ast.expression.unary.Unary;

public class Pos extends Unary {

	final static String operator = "+";
	
	public Pos(Expression operand) {
		super(operand, operator);
	}
}
