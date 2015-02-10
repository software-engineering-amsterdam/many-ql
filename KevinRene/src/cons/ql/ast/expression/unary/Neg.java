package cons.ql.ast.expression.unary;

import cons.ql.ast.expression.Expression;
import cons.ql.ast.expression.unary.Unary;

public class Neg extends Unary {

	final static String operator = "-";
	
	public Neg(Expression operand) {
		super(operand, operator);
	}
}
