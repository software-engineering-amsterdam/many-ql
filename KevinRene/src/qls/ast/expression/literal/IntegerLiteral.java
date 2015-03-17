package qls.ast.expression.literal;

import ql.ast.QLType;
import ql.ast.type.QLInteger;
import qls.ast.expression.Literal;
import qls.ast.visitor.ExpressionVisitor;
import qls.value.IntegerValue;

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
