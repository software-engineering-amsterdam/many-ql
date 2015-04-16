package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Expression.Expression;
import org.nlamah.QL.Expression.ExpressionVisitor;
import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViewControllers.IfThenBlockViewController;
import org.nlamah.QL.Literal.BooleanLiteral;

public class IfThenBlock extends FormElement 
{
	private Expression expression;
	
	public IfThenBlock(Expression expression, ArrayList<FormElement> childElements) 
	{	
		super();
		
		this.expression = expression;
		
		setChildElements(childElements);
	}
	
	public boolean isSatisfied()
	{
		BooleanLiteral booleanLiteral = (BooleanLiteral)expression.accept(new ExpressionVisitor());
		
		return booleanLiteral.value();
	}
	
	@Override
	protected FormElementViewController createViewController() 
	{
		return new IfThenBlockViewController(this);
	}
}
