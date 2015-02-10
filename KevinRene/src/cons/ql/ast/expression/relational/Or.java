package cons.ql.ast.expression.relational;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Expression;

public class Or extends Binary {

	final static String operator = "||";

	public Or(Expression left, Expression right) {
		super(left, right, operator);
	}
}
