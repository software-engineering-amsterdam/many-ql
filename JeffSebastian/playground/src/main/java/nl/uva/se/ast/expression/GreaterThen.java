package nl.uva.se.ast.expression;

import nl.uva.se.visitor.Visitor;

public class GreaterThen extends Binary {

	public GreaterThen(int lineNumber, int offset, Expression left,
			Expression right) {
		super(lineNumber, offset, left, right);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
