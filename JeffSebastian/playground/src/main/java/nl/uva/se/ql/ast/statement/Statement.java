package nl.uva.se.ql.ast.statement;

import nl.uva.se.ql.ast.Node;

public abstract class Statement extends Node {

	public Statement(int lineNumber, int offset) {
		super(lineNumber, offset);
	}
	
	public abstract void accept(StatementVisitor visitor);

}
