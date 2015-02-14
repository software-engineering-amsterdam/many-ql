package org.uva.sea.ql.model.literal;

public class BooleanLiteral extends AbstractLiteral<Boolean>{
	private final boolean booleanValue;

	public BooleanLiteral(boolean boolValue) {
		this.booleanValue = boolValue;
	}

	@Override
	public Boolean getValue() {
		return this.booleanValue;
	}	
}
