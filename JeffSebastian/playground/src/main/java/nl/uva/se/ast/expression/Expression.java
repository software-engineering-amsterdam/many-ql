package nl.uva.se.ast.expression;

import nl.uva.se.ast.Node;
import nl.uva.se.visitor.ExpressionVisitor;

public abstract class Expression extends Node {

	public Expression(int lineNumber, int offset) {
		super(lineNumber, offset);
	}
	
	public abstract <T> T accept(ExpressionVisitor<T> visitor);

}
