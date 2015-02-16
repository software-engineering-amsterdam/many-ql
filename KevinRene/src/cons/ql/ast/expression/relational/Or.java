package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.Visitor;
import cons.ql.ast.expression.Binary;

public class Or extends Binary {
	final static String operator = "||";

	public Or(Expression left, Expression right) {
		super(left, right, operator);
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
