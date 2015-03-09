package qls.ast;

import ql.ast.expression.QLType;
import ql.ast.expression.type.QLError;
import qls.ast.visitor.Visitor;

public class Identifier implements QLSNode {
	private final String identifier;
	
	public Identifier(String identifier) {
		this.identifier = identifier;
	}
	
	public QLType getType() {
		return new QLError();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return identifier;
	}

}
