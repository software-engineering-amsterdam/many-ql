package org.uva.qls.ast.type;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.visitor.TypeVisitor;

public class IdentifierType extends Type {

	public IdentifierType() {
		super();
	}
	
	public IdentifierType(CodePosition pos) {
		super(pos);
	}
	
	@Override
	public boolean isIdentifier() {
		return true;
	}
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isEqual(Type type) {
		return type.isIdentifier();
	}

	@Override
	public String toString() {
		return "Identifier";
	}

}
