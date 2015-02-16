package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class GEq extends Binary {
	public GEq(Expression left, Expression right) {
		super(left, right, ">=");
	}
}
