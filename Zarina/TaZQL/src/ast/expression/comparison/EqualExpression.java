package ast.expression.comparison;

import ast.expression.BinaryExpression;
import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

// For ==

public class EqualExpression extends BinaryExpression {
						
	public EqualExpression (Expression leftExp, Expression rightExp) {
		super (leftExp, rightExp);
	}
				
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.getLeftExpression().toString() + " == " + this.getRightExpression().toString();
	}
}


