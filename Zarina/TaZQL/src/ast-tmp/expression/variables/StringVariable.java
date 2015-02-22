package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class StringVariable extends Expression {
	private final String variable;

	public StringVariable (String variable) {
		this.variable = variable;
	}	
	
	@Override
	public String toString() {
		return variable;
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
