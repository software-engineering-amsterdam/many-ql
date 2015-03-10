package nl.uva.se.ql.ast.expression.variable;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;

public class Reference extends Expression {

	private final String name;
	
	public Reference(int lineNumber, int offset, String name) {
		super(lineNumber, offset);
		this.name = name;
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getName() {
		return name;
	}

}
