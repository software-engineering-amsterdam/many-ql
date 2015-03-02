package ast.expression.variables;

import ast.expression.Expression;
import ast.expression.IExpressionVisitor;


public class Id extends Expression {

	private final String id;
	
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
	 
	 @Override
	 public int hashCode(){
		 return id.hashCode();
	 }
	 
	 @Override
	 public boolean equals(Object object) {
		 if (object instanceof Id) {
			 return id.equals(((Id) object).getID());
		 }
		 return false;
	 }
}

