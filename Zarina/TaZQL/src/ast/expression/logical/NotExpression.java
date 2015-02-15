package ast.expression.logical;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class NotExpression extends Expression {
				
	private Expression expression;
					
	public NotExpression (Expression expression) {
		this.expression = expression;
	}
					
	public Expression getExpression() {
		return expression;
	}
					
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return " ! " + getExpression();
	}

}



