package cons.ql.ast.expression.unary;

import cons.ql.ast.Expression;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.Unary;

public class Not extends Unary {
	final static String operator = "!";
	
	public Not(Expression operand) {
		super(operand, operator);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
