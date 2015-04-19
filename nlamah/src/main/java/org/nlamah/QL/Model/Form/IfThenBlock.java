package org.nlamah.QL.Model.Form;

import java.util.ArrayList;

import org.nlamah.QL.Interfaces.QLFormElementVisitor;
import org.nlamah.QL.Interfaces.QLNodeVisitor;
import org.nlamah.QL.Model.Expression.Abstract.Expression;
import org.nlamah.QL.Model.Expression.Literal.BooleanLiteral;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.DeclaringFormElement;
import org.nlamah.QL.Model.Form.Abstract.QLNode;
import org.nlamah.QL.Visitors.ExpressionVisitor;

public class IfThenBlock extends DeclaringFormElement 
{
	private Expression expression;
	
	public IfThenBlock(Expression expression, ArrayList<FormElement> childElements) 
	{	
		super(childElements);
		
		this.expression = expression;
		
		expression.setParentNode(this);
	}
	
	public boolean isSatisfied()
	{
		BooleanLiteral booleanLiteral = (BooleanLiteral) expression.accept(new ExpressionVisitor());
		
		return booleanLiteral.primitiveValue();
	}
	
	@Override 
	 public boolean equals(Object object) 
	 {
		if (!super.equals(object))
		 {
			 return false;
		 }
		 
		 if (!(object instanceof IfThenBlock))
		 {
			 return false;
		 }
		 
		 IfThenBlock value = (IfThenBlock)object;
		 
		 if (!(this.expression.equals(value.expression)))
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
