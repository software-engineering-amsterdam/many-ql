package org.uva.sea.ql.model.literal;

public class IntegerLiteral extends AbstractLiteral<Integer> {

	public final int intValue;
	
	public IntegerLiteral(int intValue) {
		this.intValue = intValue;
	}
	
	@Override
	public Integer getValue() {
		return intValue;
	}

}
