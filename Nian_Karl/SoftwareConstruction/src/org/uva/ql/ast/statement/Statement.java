package org.uva.ql.ast.statement;

import org.uva.ql.antlr.QLParser.ExpressionContext;
import org.uva.ql.ast.QLNode;
import org.uva.ql.visitor.StatementVisitable;
import org.uva.utility.CodePosition;

public abstract class Statement extends ExpressionContext implements QLNode, StatementVisitable{

	private final CodePosition position;

	public Statement(CodePosition pos) {
		this.position = pos;
	}
	
	public CodePosition getPosition() {
		return position;
	}
}
