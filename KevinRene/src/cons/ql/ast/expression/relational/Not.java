package cons.ql.ast.expression.relational;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.Unary;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.visitor.Visitor;

public class Not extends Unary {
	public Not(Expression operand) {
		super(operand, "!");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLBoolean();
	}
}
