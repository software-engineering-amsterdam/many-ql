package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Expression;

public class Sub extends Binary {

	final static String operator = "-";
	
	public Sub(Expression left, Expression right) {
		super(left, right, operator);
	}
}
