package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class LEq extends Binary {
	public LEq(Expression left, Expression right) {
		super(left, right, "<=");
	}
}
