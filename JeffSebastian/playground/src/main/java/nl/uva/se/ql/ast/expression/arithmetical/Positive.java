package nl.uva.se.ql.ast.expression.arithmetical;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;
import nl.uva.se.ql.ast.expression.Unary;

public class Positive extends Unary {

	public Positive(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
