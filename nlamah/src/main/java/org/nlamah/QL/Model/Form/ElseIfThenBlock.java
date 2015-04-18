package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.ViewControllers.Form.ElseIfThenBlockViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Visitors.QLNodeVisitor;

public class ElseIfThenBlock extends DeclaringFormElement 
{
	private Expression expression;
	
	public ElseIfThenBlock(Expression expression, ArrayList<FormElement> childElements) 
	{
		super(childElements);
		
		this.expression = expression;
		
		expression.setParentNode(this);
	}
	
	public boolean isSatisfied()
	{
		return false;
	}
	
	@Override
	protected FormElementViewController createViewController() 
	{
		return new ElseIfThenBlockViewController(this);
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
		 
		 if (!(object instanceof ElseIfThenBlock))
		 {
			 return false;
		 }
		 
		 ElseIfThenBlock value = (ElseIfThenBlock)object;
		 
		 if (!(this.expression.equals(value.expression)))
		 {
			 return false;
		 }
		 
		 return true;
	 }
}
