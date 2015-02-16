package org.uva.sea.ql.model.literal;

import org.uva.sea.ql.model.value.IntegerValue;

public class NumberLiteral  extends AbstractLiteral{

	private final int intValue;
	
	public NumberLiteral(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public IntegerValue evaluateExpression() {
		return new IntegerValue(intValue);
	}
	
	
}
