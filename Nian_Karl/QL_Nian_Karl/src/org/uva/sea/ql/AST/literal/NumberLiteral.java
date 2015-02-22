package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.value.IntegerValue;

public class NumberLiteral  extends AbstractLiteral{

	private final int intValue;
	
	public NumberLiteral(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public IntegerValue interpretExpression() {
		return new IntegerValue(intValue);
	}
}
