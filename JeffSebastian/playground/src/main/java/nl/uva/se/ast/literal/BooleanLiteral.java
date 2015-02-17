package nl.uva.se.ast.literal;

import nl.uva.se.visitor.Visitor;

public class BooleanLiteral extends AbstractLiteral {

	public BooleanLiteral(int lineNumber, int offset, String name) {
		super(lineNumber, offset, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
