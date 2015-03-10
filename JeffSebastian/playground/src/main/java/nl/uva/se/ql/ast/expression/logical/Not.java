package nl.uva.se.ql.ast.expression.logical;

import nl.uva.se.ql.ast.expression.Expression;
import nl.uva.se.ql.ast.expression.ExpressionVisitor;
import nl.uva.se.ql.ast.expression.Unary;

public class Not extends Unary{

	public Not(int lineNumber, int offset, Expression singleExpression) {
		super(lineNumber, offset, singleExpression);
	}

	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
