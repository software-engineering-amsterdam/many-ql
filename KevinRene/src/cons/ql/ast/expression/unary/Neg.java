package cons.ql.ast.expression.unary;

import cons.ql.ast.Expression;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.Unary;

public class Neg extends Unary {
	public Neg(Expression operand) {
		super(operand, "-");
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
