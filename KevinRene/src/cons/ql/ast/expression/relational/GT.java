package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class GT extends Binary {	
	public GT(Expression left, Expression right) {
		super(left, right, ">");
	}
}
