package org.uva.ql.ast.expression;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;

public abstract class Expression implements Node {
	private final CodePosition position;

	public Expression(CodePosition pos) {
		this.position = pos;
	}

	public CodePosition getPosition() {
		return position;
	}
}
