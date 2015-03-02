package org.uva.ql.ast.expression;

import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;

public abstract class Expression implements Node {
	private final CodePosition position;

	public Expression(CodePosition pos) {
		this.position = pos;
	}

	public CodePosition getPosition() {
		return position;
	}
	
	public abstract Type getType(TypeChecker typeChecker);
	
}
