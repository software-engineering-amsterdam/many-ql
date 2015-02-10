package cons.ql.ast.expression.relational;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Expression;

public class LEq extends Binary {
	
	final static String operator = "<=";

	public LEq(Expression left, Expression right) {
		super(left, right, operator);
	}
}
