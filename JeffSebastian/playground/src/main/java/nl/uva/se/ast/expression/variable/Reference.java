package nl.uva.se.ast.expression.variable;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.visitor.Visitor;

public class Reference extends Expression {

	private final String name;
	
	public Reference(int lineNumber, int offset, String name) {
		super(lineNumber, offset);
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}

}
