package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.value.BooleanValue;

public class BooleanLiteral extends AbstractLiteral{
	private final boolean booleanValue;

	public BooleanLiteral(boolean boolValue) {
		this.booleanValue = boolValue;
	}

	@Override
	public BooleanValue interpretExpression() {
		return new BooleanValue(booleanValue);
	}	
}
