package ast.expression.variables;

import ast.expression.IExpressionVisitor;

public class BooleanVariable extends Variable { //<Boolean> {
	private final Boolean booleanVariable;

	public BooleanVariable (boolean booleanVariable) {
		this.booleanVariable = booleanVariable;
		//super(booleanVariable);
	}
	
	public Boolean getVariable(){
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
