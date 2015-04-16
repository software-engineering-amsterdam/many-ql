package org.nlamah.QL.FormModel;

import java.util.ArrayList;

import org.nlamah.QL.Expression.Expression;
import org.nlamah.QL.FormViewControllers.ElseIfThenBlockViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class ElseIfThenBlock extends FormElement 
{
	private Expression expression;
	private ArrayList<FormElement> formElements;
	
	public ElseIfThenBlock(Expression expression, ArrayList<FormElement> formElements) 
	{
		super();
		
		this.expression = expression;
		this.formElements = formElements;
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
}
