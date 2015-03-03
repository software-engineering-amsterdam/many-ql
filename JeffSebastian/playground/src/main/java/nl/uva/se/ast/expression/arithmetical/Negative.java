package nl.uva.se.ast.expression.arithmetical;

import nl.uva.se.ast.expression.Expression;
import nl.uva.se.ast.expression.Unary;
import nl.uva.se.visitor.ExpressionVisitor;

public class Negative extends Unary {

	public Negative(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
