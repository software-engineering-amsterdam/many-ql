package nl.uva.se.ast.expression.logical;

import nl.uva.se.ast.expression.Binary;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.visitor.ExpressionVisitor;

public class NotEqual extends Binary {

	public NotEqual(int lineNumber, int offset, Expression left,
			Expression right) {
		super(lineNumber, offset, left, right);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
