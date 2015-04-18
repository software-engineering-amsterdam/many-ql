package org.nlamah.QL.Model.Expression.Abstract;


public abstract class UnaryExpression extends ComposedExpression 
{
	private Expression expression;
	
	public UnaryExpression (Expression expression)
	{
		super();
		
		this.expression = expression;
		
		expression.setParentNode(this);
	}
	
	public Expression expression()
	{
		return this.expression;
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof UnaryExpression))
		 {
			 return false;
		 }
		 
		 UnaryExpression value = (UnaryExpression)object;
		 
		 if (!(this.expression.equals(value.expression)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
