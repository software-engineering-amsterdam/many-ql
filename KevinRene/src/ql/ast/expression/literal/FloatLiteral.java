package ql.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import ql.value.FloatValue;

public class FloatLiteral extends Literal<FloatValue> {	
	
	public FloatLiteral(float value) {
		super(new FloatValue(value));
	}
	
	@Override
	public QLType getType() {
		return getValue().getType();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}
