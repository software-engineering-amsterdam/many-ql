package cons.ql.ast.expression.unary;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.visitor.Visitor;

public class Pos extends Unary {
	public Pos(Expression operand) {
		super(operand, "+");
	}
	
	@Override
	public void accept(Visitor visitor) {		
		visitor.visit(this);
	}
}
