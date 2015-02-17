package cons.ql.ast.expression.literal;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.visitor.Visitor;

public class FloatLiteral extends Expression {	
	float value;
	
	public FloatLiteral(float value) {
		this.value = value;
	}
	
	@Override
	public void accept(Visitor visitor) {}

	@Override
	public String toString() {
		return "" + value;
	}

	@Override
	public QLType getType() {
		return new QLFloat();
	}
}
