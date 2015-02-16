package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class Div extends Binary {
	public Div(Expression left, Expression right) {
		super(left, right, "/");
	}
}