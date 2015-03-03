package nl.uva.se.ast.expression.arithmetical;

import nl.uva.se.ast.expression.Binary;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.visitor.ExpressionVisitor;

public class Divide extends Binary{

	public Divide(int lineNumber, int offset, Expression left, 
			Expression right) {
		super(lineNumber, offset, left, right);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
