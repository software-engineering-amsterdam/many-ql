package org.uva.ql.ast.expression;

import org.uva.ql.ast.QLNode;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.TypeChecker;
import org.uva.ql.visitor.ExpressionVisitable;
import org.uva.utility.CodePosition;

public abstract class Expression implements QLNode, ExpressionVisitable {
	private final CodePosition position;

	public Expression(CodePosition pos) {
		this.position = pos;
	}

	public CodePosition getPosition() {
		return position;
	}
	
	public abstract Type getType(TypeChecker typeChecker);
	
}
