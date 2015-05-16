package org.nlamah.QL.Model.Expression.Literal;

import org.nlamah.QBase.QBaseQuestionType;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.ValueExpression;

public class BooleanLiteral extends ValueExpression
{	
	public BooleanLiteral(boolean booleanValue)
	{
		this(booleanValue ? "yes" : "no");
	}
	
	public BooleanLiteral(String booleanValueString)
	{
		super(booleanValueString, QBaseQuestionType.BOOLEAN);
		
		assert(booleanValueString.equals("yes") || booleanValueString.equals("no"));
	}
	
	public boolean primitiveValue()
	{
		return valueString.equals("yes") ? true : false; 
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
		 
		 if (!(object instanceof BooleanLiteral))
		 {
			 return false;
		 }
		 
		 BooleanLiteral value = (BooleanLiteral) object;
		 
		 if (value.primitiveValue() != primitiveValue())
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
