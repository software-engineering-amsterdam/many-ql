package ast.expression.variables;

import ast.expression.IExpressionVisitor;
import ast.type.DigitsType;

public class IntegerVariable extends Variable { //<Integer> {
	private final Integer intVariable;

	public IntegerVariable (int intVariable) {
		this.intVariable = intVariable;
		//super(intVariable);
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
	public DigitsType getExpressionType() {
		return new DigitsType();
	}

}
