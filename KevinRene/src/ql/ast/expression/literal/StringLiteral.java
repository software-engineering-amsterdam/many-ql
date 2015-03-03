package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.expression.QLType;
import ql.ast.expression.type.QLString;
import ql.ast.visitor.Visitor;
import ql.value.StringValue;

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
