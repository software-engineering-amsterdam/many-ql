package org.uva.ql.ast.type;

import org.uva.ql.ast.visitor.Visitor;

public class IntType extends Type {
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Int";
	}
	
}
