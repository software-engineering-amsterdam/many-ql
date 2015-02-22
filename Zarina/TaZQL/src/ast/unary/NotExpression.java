package ast.unary;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class NotExpression extends UnaryExpression {
									
	public NotExpression (Expression expression) {
		super(expression);
	}
					
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return " ! " + this.getUnaryExpression().toString();
	}
}



