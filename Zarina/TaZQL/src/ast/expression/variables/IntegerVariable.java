package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class IntegerVariable extends Expression {
	private final Integer intVariable;

	public IntegerVariable (Integer intVariable) {
		this.intVariable = intVariable;
	}	
	
	public Integer getValue() {
		return intVariable;
	}
	
	@Override
	public String toString() {
		return intVariable.toString();
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
