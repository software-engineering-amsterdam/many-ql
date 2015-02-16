package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.Binary;

public class Add extends Binary {
	final static String operator = "+";
	
	public Add(Expression left, Expression right) {		
		super(left, right, operator);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
