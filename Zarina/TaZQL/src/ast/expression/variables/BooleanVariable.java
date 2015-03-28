package ast.expression.variables;

import ast.expression.IExpressionVisitor;
import ast.type.ChoiceType;

public class BooleanVariable extends Variable { 
	private final Boolean booleanVariable;

	public BooleanVariable (boolean booleanVariable) {
		this.booleanVariable = booleanVariable;
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

	@Override
	public ChoiceType getType() {
		return new ChoiceType();
	}
}
