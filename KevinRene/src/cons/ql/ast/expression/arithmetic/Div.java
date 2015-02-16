package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.visitor.Visitor;

public class Div extends Binary {
	public Div(Expression left, Expression right) {
		super(left, right, "/");
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}