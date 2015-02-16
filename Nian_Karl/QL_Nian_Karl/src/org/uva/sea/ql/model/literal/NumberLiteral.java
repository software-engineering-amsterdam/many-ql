package org.uva.sea.ql.model.literal;

public class NumberLiteral extends AbstractLiteral<Integer> {

	private final int intValue;
	
	public NumberLiteral(int intValue) {
		this.intValue = intValue;
	}
	
	@Override
	public Integer getValue() {
		return intValue;
	}

}
