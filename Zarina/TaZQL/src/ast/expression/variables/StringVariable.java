package ast.expression.variables;

import ast.expression.IExpressionVisitor;
import ast.type.TextType;

public class StringVariable extends Variable { 
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

	@Override
	public TextType getExpressionType() {
		return new TextType();
	}
}
