package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class And extends Binary {	
	public And(Expression left, Expression right) {
		super(left, right, "&&");
	}
}
