package org.nlamah.QL.Model.Expression.Binary;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.BinaryLogicalExpression;
import org.nlamah.QL.Model.Expression.Abstract.Expression;

public class SmallerThanEqualExpression extends BinaryLogicalExpression 
{
	public SmallerThanEqualExpression(Expression leftHandExpression, Expression rightHandExpression)  
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
		 
		 if (!(object instanceof SmallerThanEqualExpression))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	@Override
	public boolean isSafeForType(QBaseQuestionType type) 
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
