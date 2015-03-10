package org.uva.qls.ast;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.utility.CodePosition;

public class Question extends BaseNode {
	private final Identifier identifier;

	public Question(Identifier identifier, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

}
