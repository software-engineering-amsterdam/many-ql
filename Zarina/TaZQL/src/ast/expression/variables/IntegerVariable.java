package ast.expression.variables;

import ast.expression.IExpressionVisitor;
import ast.type.IntegerType;

public class IntegerVariable extends Variable { 
	private final Integer intVariable;

	public IntegerVariable (int intVariable) {
		this.intVariable = intVariable;
	}	
	
	public int getVariable() {
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

	@Override
	public IntegerType getType() {
		return new IntegerType();
	}
}