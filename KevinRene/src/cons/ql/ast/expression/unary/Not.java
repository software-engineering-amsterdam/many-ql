package cons.ql.ast.expression.unary;

import cons.ql.ast.expression.Expression;
import cons.ql.ast.expression.unary.Unary;

public class Not extends Unary {

	final static String operator = "!";
	
	public Not(Expression operand) {
		super(operand, operator);
	}
}
