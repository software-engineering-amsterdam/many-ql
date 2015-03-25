package qls.ast.expression.literal;

import ql.ast.QLType;
import ql.value.StringValue;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;

public class StringLiteral extends Literal<StringValue> {
	public StringLiteral(String value) {
		super(new StringValue(value));
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
