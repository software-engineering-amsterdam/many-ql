package nl.uva.se.ast.statement;

import nl.uva.se.ast.Node;

public abstract class Statement extends Node {

	public Statement(int lineNumber, int offset) {
		super(lineNumber, offset);
	}

}
