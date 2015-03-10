package nl.uva.se.ql.ast.expression.literal;

import nl.uva.se.ql.ast.expression.ExpressionVisitor;

public class StringLiteral extends AbstractLiteral<String> {

	public StringLiteral(int lineNumber, int offset, String value) {
		super(lineNumber, offset, value);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
