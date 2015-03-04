package ast.expression.variables;

import ast.expression.IExpressionVisitor;

public class StringVariable extends Variable { //<String> {
	private final String stringVariable;
	
	public StringVariable (String stringVariable) {
		//super(stringVariable);
		this.stringVariable = stringVariable;
	}	
	
	//@Override
	public String getVariable() {
		return stringVariable;
	}
	
	@Override
	public String toString() {
		return stringVariable.toString();
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
