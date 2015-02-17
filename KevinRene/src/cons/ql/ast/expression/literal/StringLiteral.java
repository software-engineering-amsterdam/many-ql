package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;

public class StringLiteral extends Literal<String> {	
	
	public StringLiteral(String value) {
		super(value);
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public void accept(Visitor visitor) {}
}
