package org.uva.qls.ast.sheet;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IdentifierLiteral;

public class Question extends BaseNode {
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

}
