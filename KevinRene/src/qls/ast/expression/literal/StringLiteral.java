package qls.ast.expression.literal;

import qls.ast.expression.QLSLiteral;
import qls.ast.visitor.QLSVisitor;
import qls.value.QLSStringValue;

public class StringLiteral extends QLSLiteral<QLSStringValue> {
	public StringLiteral(QLSStringValue value) {
		super(value);
	}

	@Override
	public <T> T accept(QLSVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
