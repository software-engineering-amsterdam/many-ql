package org.nlamah.QL.Model.Expression.Unary;

import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Abstract.UnaryComputationalExpression;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class MinusExpression extends UnaryComputationalExpression 
{
	public MinusExpression(Expression expression) 
	{
		super(expression);
	}

	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof MinusExpression))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	@Override
	public boolean isSafeForType(QuestionReturnType type) 
	{
		switch(type)
		{
			case BOOLEAN: return false;
			case TEXT: return false;
			case NUMBER: return true;
		}
		
		return false;
	}
}
