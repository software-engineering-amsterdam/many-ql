package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;

public class Sub extends Binary {
	public Sub(Expression left, Expression right) {
		super(left, right, "-");
	}
}
