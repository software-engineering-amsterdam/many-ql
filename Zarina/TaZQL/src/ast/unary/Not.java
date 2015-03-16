package ast.unary;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

public class Not extends Unary {
									
	public Not (Expression expression) {
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
	public ChoiceType getType() {
		return new ChoiceType();
	}
}



