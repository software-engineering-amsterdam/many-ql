package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.expression.QLType;
import ql.ast.expression.type.QLFloat;
import ql.ast.visitor.Visitor;
import ql.value.FloatValue;

public class FloatLiteral extends Literal<FloatValue> {	

	public FloatLiteral(float value) {
		super(new FloatValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	
}
