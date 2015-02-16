package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class Mul extends Binary {
	public Mul(Expression left, Expression right) {
		super(left, right, "*");
	}
}
