package org.nlamah.QL.FormModel;

import org.nlamah.QL.FormViews.ComputedQuestionView;
import org.nlamah.QL.FormViews.FormElementView;
import org.nlamah.QL.FormViews.VisibilityStrategy;

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
	public FormElementView createView() 
	{
		return new ComputedQuestionView(this);
	}

	@Override
	public String toParseTreeString() {
		// TODO Auto-generated method stub
		return null;
	}
}
