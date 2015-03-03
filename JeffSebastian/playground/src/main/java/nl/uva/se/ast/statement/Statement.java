package nl.uva.se.ast.statement;

import nl.uva.se.ast.Node;
import nl.uva.se.visitor.StatementVisitor;

public abstract class Statement extends Node {

	public Statement(int lineNumber, int offset) {
		super(lineNumber, offset);
	}
	
	public abstract void accept(StatementVisitor visitor);

}
