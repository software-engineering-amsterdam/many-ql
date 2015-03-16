package ast.unary;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.IntegerType;
import ast.type.Type;

public class Minus extends Unary {
	
	public Minus (Expression expression) {
		super(expression);
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return " - " + this.getUnaryExpression().toString();
	}

	@Override
	public Type getType() {
		return new IntegerType();
	}
}