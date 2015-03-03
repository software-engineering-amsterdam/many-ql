package qls.ast.literal;

import ql.ast.expression.QLType;
import ql.ast.expression.type.QLString;
import ql.value.StringValue;
import qls.ast.Literal;
import qls.ast.visitor.Visitor;

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
