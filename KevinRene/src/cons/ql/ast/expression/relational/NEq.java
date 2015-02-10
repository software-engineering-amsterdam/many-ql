package cons.ql.ast.expression.relational;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Expression;

public class NEq extends Binary {
	final static String operator = "!=";

	public NEq(Expression left, Expression right) {
		super(left, right, operator);
	}
}
