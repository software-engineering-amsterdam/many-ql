package org.uva.qls.ast.sheet;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.visitor.SheetVisitable;
import org.uva.qls.visitor.SheetVisitor;

public class Question extends BaseNode implements SheetVisitable{
	private final IdentifierLiteral identifier;

	public Question(IdentifierLiteral identifier, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
	}

	public IdentifierLiteral getIdentifier() {
		return identifier;
	}
	
	@Override
	public String toString() {
		return identifier.getValue().toString();
	}

	@Override
	public <T> T accept(SheetVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
