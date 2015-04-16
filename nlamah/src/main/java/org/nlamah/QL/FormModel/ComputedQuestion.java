package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViewControllers.ComputedQuestionViewController;
import org.nlamah.QL.FormViewControllers.FormElementViewController;

public class ComputedQuestion extends Question 
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
	protected FormElementViewController createViewController() 
	{
		return new ComputedQuestionViewController(this);
	}
}
