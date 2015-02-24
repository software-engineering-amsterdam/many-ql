package org.uva.sea.ql.AST.literal;

import org.uva.sea.ql.AST.visitor.Visitor;


public class BooleanLiteral extends AbstractLiteral{
	private final boolean booleanValue;

	public BooleanLiteral(boolean boolValue) {
		this.booleanValue = boolValue;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
}
