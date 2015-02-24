package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;

public class BooleanVariable extends Expression {
	private final Boolean booleanVariable;

	public BooleanVariable (Boolean booleanVariable) {
		this.booleanVariable = booleanVariable;
	}
	
	public Boolean getValue(){
		return booleanVariable;
	}
	
	@Override
	public String toString() {
		return booleanVariable.toString();
	}
	
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
