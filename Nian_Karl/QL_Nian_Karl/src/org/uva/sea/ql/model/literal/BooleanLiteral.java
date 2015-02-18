package org.uva.sea.ql.model.literal;

import org.uva.sea.ql.model.value.BooleanValue;

public class BooleanLiteral extends AbstractLiteral{
	private final boolean booleanValue;

	public BooleanLiteral(boolean boolValue) {
		this.booleanValue = boolValue;
	}

	@Override
	public BooleanValue evaluateExpression() {
		return new BooleanValue(booleanValue);
	}	
}
