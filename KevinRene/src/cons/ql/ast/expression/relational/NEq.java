package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class NEq extends Binary {
	public NEq(Expression left, Expression right) {
		super(left, right, "!=");
	}
}
