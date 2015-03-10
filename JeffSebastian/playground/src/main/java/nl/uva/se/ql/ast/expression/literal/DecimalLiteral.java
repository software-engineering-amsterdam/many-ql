package nl.uva.se.ql.ast.expression.literal;

import java.math.BigDecimal;

import nl.uva.se.ql.ast.expression.ExpressionVisitor;

public class DecimalLiteral extends AbstractLiteral<BigDecimal> {

	public DecimalLiteral(int lineNumber, int offset, BigDecimal value) {
		super(lineNumber, offset, value);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
