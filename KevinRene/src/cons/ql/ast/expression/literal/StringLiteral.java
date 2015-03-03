package cons.ql.ast.expression.literal;

import cons.ql.ast.expression.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.visitor.Visitor;
import cons.value.StringValue;

public class StringLiteral extends Literal<StringValue> {	
	
	public StringLiteral(String value) {
		super(new StringValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	
}
