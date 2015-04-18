package org.nlamah.QL.Model.Expression.Binary;

import org.nlamah.QL.Model.Expression.Abstract.BinaryLogicalExpression;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Model.Form.Abstract.QuestionReturnType;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class OrExpression extends BinaryLogicalExpression
{
	public OrExpression(Expression leftHandExpression, Expression rightHandExpression) 
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
		 
		 if (!(object instanceof OrExpression))
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
			case BOOLEAN: return true;
			case TEXT: return false;
			case NUMBER: return false;
		}
		
		return false;
	}
}
