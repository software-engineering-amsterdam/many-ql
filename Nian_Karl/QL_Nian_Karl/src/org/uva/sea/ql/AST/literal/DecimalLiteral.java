package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.visitor.Visitor;

public class DecimalLiteral extends AbstractLiteral {

	private final double doubleValue;

	public DecimalLiteral(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
}
