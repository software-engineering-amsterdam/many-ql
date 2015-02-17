package nl.uva.se.ast.literal;

import nl.uva.se.ast.Node;
import nl.uva.se.visitor.Visitor;

public class Literal<T> extends Node {
	
	private final T value;
	
	public Literal(int lineNumber, int offset, T value) {
		super(lineNumber, offset);
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public T getValue() {
		return value;
	}	
}
