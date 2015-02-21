package cons.ql.ast.expression.unary;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.visitor.Visitor;

public class Neg extends Unary {
	public Neg(Expression operand) {
		super(operand, "-");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	//TODO: Add a superclass for numeric types.
	@Override
	public QLType getType() {
		return new QLFloat();
	}
}
