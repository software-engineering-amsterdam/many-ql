package nl.uva.se.ql.ast.expression;

import nl.uva.se.ql.ast.Node;

public abstract class Expression extends Node {

	public Expression(int lineNumber, int offset) {
		super(lineNumber, offset);
	}
	
	public abstract <T> T accept(ExpressionVisitor<T> visitor);

}
