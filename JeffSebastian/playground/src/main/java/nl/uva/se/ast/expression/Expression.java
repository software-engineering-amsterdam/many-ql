package nl.uva.se.ast.expression;

import nl.uva.se.ast.Node;

public abstract class Expression extends Node {

	public Expression(int lineNumber, int offset) {
		super(lineNumber, offset);
	}

}
