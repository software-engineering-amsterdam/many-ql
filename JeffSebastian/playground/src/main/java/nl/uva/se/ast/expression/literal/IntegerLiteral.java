package nl.uva.se.ast.expression.literal;

import nl.uva.se.visitor.ExpressionVisitor;

public class IntegerLiteral extends AbstractLiteral<Integer> {

	public IntegerLiteral(int lineNumber, int offset, Integer value) {
		super(lineNumber, offset, value);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
