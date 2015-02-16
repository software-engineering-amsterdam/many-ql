package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class LT extends Binary {
	public LT(Expression left, Expression right) {
		super(left, right, "<");
	}
}
