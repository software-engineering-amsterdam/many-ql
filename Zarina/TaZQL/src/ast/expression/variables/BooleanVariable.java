package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class BooleanVariable extends Expression {
	private final Boolean variable;

	public BooleanVariable (boolean variable) {
		this.variable = variable;
	}	
	
	@Override
	public String toString() {
		return variable.toString();
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
