package cons.ql.ast.expression.unary;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Unary;

public class Pos extends Unary {
	public Pos(Expression operand) {
		super(operand, "+");
	}
}
