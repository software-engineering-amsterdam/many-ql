package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Expression;

public class Div extends Binary {
	
	final static String operator = "/";

	public Div(Expression left, Expression right) {
		super(left, right, operator);
	}
}