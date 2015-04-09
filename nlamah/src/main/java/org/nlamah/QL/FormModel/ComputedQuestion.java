package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViewControllers.ComputedQuestionViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;
import org.nlamah.QL.FormViewControllers.VisibilityStrategy;

public class ComputedQuestion extends Question implements VisibilityStrategy 
{
	private String computationExpression;
	
	public ComputedQuestion(String identifier, String questionLabel, String type, String computationExpression) 
	{
		super(identifier, questionLabel, type);
		
		this.computationExpression = computationExpression;
	}
	
	public String getComputationExpression()
	{
		return this.computationExpression;
	}

	@Override
	public String toParseTreeString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormElementViewController createViewController() 
	{
		return new ComputedQuestionViewController(this);
	}
}
