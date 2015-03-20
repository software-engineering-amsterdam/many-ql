package ql.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import ql.value.IntegerValue;

public class IntegerLiteral extends Literal<IntegerValue> {	

	public IntegerLiteral(int value) {
		super(new IntegerValue(value));
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
