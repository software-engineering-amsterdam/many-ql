package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class StringVariable extends Expression {
	private final String stringVariable;

	public StringVariable (String stringVariable) {
		this.stringVariable = stringVariable;
	}	
	
	public String getValue() {
		return stringVariable;
	}
	
	@Override
	public String toString() {
		return stringVariable;
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
