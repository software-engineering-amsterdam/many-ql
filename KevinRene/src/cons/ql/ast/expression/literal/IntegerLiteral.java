package cons.ql.ast.expression.literal;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.visitor.Visitor;

public class IntegerLiteral extends Expression {	
	int value;
	
	public IntegerLiteral(int value) {
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
		return new QLInteger();
	}
}
