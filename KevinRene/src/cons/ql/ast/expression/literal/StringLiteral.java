package cons.ql.ast.expression.literal;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;

public class StringLiteral extends Expression {	
	String value;
	
	public StringLiteral(String value) {
		this.value = value;
	}
	
	@Override
	public void accept(Visitor visitor) {}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public QLType getType() {
		return new QLString();
	}
}
