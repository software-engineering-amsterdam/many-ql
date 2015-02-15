package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;


public class Id extends Expression {

	private String id;
	
	public Id(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}

	@Override
	public String toString() {
		return id;
	}

	 @Override
	 public <T> T accept(IExpressionVisitor<T> visitor) {
		 return visitor.visit(this);
	 }
}

