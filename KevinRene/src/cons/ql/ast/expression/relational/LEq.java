package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.visitor.Visitor;

public class LEq extends Binary {
	public LEq(Expression left, Expression right) {
		super(left, right, "<=");
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
