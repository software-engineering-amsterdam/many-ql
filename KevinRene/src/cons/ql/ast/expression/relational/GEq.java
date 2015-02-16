package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.visitor.Visitor;

public class GEq extends Binary {
	public GEq(Expression left, Expression right) {
		super(left, right, ">=");
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
