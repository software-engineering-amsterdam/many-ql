package org.uva.ql.ast.statement;

import org.uva.ql.antlr.QLParser.ExpressionContext;
import org.uva.ql.ast.Node;
import org.uva.ql.ast.builder.CodePosition;

public abstract class Statement extends ExpressionContext implements Node{

	private final CodePosition position;

	public Statement(CodePosition pos) {
		this.position = pos;
	}
	
	public CodePosition getPosition() {
		return position;
	}
}
