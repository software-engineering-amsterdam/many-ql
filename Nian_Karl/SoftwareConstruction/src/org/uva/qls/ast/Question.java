package org.uva.qls.ast;

import org.uva.ql.ast.QLBaseNode;
import org.uva.ql.ast.QLNode;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.utility.CodePosition;

public class Question extends QLBaseNode{
	private final Identifier identifier;

	public Question(Identifier identifier, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}


}
