package org.uva.qls.ast;

import org.uva.ql.ast.expression.literal.Identifier;

public class Question {
	private final Identifier identifier;

	public Question(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}


}
