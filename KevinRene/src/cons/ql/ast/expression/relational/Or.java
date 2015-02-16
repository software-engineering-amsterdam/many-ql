package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class Or extends Binary {
	public Or(Expression left, Expression right) {
		super(left, right, "||");
	}
}
