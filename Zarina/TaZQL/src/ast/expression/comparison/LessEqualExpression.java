package ast.expression.comparison;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

// Less than or equal to(<=)

public class LessEqualExpression extends BinaryExpression {
								
	public LessEqualExpression (Expression leftExp, Expression rightExp) {
		super(leftExp, rightExp);
	}
									
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.getLeftExpression().toString() + " <= " + super.getRightExpression().toString();
	}
}



