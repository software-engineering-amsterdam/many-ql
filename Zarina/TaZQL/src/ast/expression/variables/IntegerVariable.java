package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class IntegerVariable extends Expression {
	private final Integer variable;

	public IntegerVariable (Integer variable) {
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
