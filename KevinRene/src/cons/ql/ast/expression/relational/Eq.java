package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class Eq extends Binary {
	public Eq(Expression left, Expression right) {
		super(left, right, "==");
	}
}
