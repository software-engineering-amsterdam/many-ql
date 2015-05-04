package org.nlamah.QLS.View.Controllers;

import org.nlamah.QLS.Model.Declaration.StyledQuestion;

public class StyledQuestionViewController extends StylesheetViewController 
{
	StyledQuestion question;

	public StyledQuestionViewController(RootFormViewControllerStyled rootViewController, StyledQuestion question, StylesheetViewController parentViewController) 
	{
		super(rootViewController, parentViewController);
		
		this.question = question;
	}

	@Override
	public int neededViewHeight() 
	{
		return 0;
	}
}
