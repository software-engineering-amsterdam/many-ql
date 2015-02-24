package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.visitor.Visitor;

public class NumberLiteral  extends AbstractLiteral{

	private final int intValue;
	
	public NumberLiteral(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
}
