package nl.uva.se.ast.expression.literal;

import nl.uva.se.visitor.Visitor;

public class StringLiteral extends AbstractLiteral {

	public StringLiteral(int lineNumber, int offset, String name) {
		super(lineNumber, offset, name);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
