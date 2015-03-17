package qls.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.type.QLString;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;
import qls.value.StringValue;

public class StringLiteral extends Literal<StringValue> {
	public StringLiteral(String value) {
		super(new StringValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLString();
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
