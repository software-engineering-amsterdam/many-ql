package ast.unary;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;
import ast.type.Type;

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

	@Override
	public ChoiceType getExpressionType() {
		return new ChoiceType();
	}
}



