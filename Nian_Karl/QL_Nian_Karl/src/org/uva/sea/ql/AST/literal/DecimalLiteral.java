package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.value.DoubleValue;

public class DecimalLiteral extends AbstractLiteral {

	private final double doubleValue;

	public DecimalLiteral(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	@Override
	public DoubleValue interpretExpression() {
		return new DoubleValue(doubleValue);
	}

}
