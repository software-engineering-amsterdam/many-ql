package ql.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.expression.Literal;
import ql.ast.visitor.ExpressionVisitor;
import ql.value.MoneyValue;

public class MoneyLiteral extends Literal<MoneyValue> {	
	
	public MoneyLiteral(float value) {
		super(new MoneyValue(value));
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
