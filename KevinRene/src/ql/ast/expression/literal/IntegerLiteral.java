package ql.ast.expression.literal;

import ql.ast.expression.Literal;
import ql.ast.expression.QLType;
import ql.ast.expression.type.QLInteger;
import ql.ast.visitor.ExpressionVisitor;
import ql.value.IntegerValue;

public class IntegerLiteral extends Literal<IntegerValue> {	

	public IntegerLiteral(int value) {
		super(new IntegerValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
}
