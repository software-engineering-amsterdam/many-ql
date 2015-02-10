package cons.ql.ast.expression.relational;

import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.Expression;

public class GT extends Binary {
	
	final static String operator = ">";

	public GT(Expression left, Expression right) {
		super(left, right, operator);
	}
}
