package org.nlamah.QL.Model.Expression.Binary;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.EqualityExpression;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Abstract.LiteralType;

public class EqualExpression extends EqualityExpression 
{
	public EqualExpression(Expression leftHandExpression, Expression rightHandExpression) 
	{
		super(leftHandExpression, rightHandExpression);
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
		 
		 if (!(object instanceof EqualExpression))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	@Override
	public boolean isSafeForType(LiteralType type) 
	{
		switch(type)
		{
			case BOOLEAN: return true;
			case TEXT: return true;
			case NUMBER: return true;
		}
		
		return false;
	}
}
