package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;
import ast.type.Type;


public class Id extends Expression {
	private final String id;
	private final Type type;	
	
	public Id(String id, Type type) {
		this.id = id;
		this.type = type;
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
	 
	@Override
	public Type getType() {
		return this.type;
	}	
}
