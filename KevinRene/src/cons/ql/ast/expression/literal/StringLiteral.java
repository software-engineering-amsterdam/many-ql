package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;

public class StringLiteral extends Literal<String> {	
	String value;
	
	public StringLiteral(String value) {
		super(value);
	}
	
	@Override
	public void accept(Visitor visitor) {}

	@Override
	public QLType getType() {
		return new QLString();
	}
}
