package org.nlamah.QL.Model.Form;

import java.util.List;

import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Abstract.ConditionalBlockChildWithExpression;
import org.nlamah.QL.Model.Form.Abstract.FormElement;

public class ElseIfThenBlock extends ConditionalBlockChildWithExpression
{
	public ElseIfThenBlock(Expression expression, List<FormElement> childElements) 
	{
		super(expression, childElements);
		
		expression.setParentNode(this);
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof ElseIfThenBlock))
		 {
			 return false;
		 }
		 
		 return true;
	 }
	
	@Override
	public QLNode accept(QLNodeVisitor visitor) 
	{
		return visitor.visit(this);
	}

	@Override
	public void accept(QLFormElementVisitor visitor) 
	{
		visitor.visit(this);
	}
}
