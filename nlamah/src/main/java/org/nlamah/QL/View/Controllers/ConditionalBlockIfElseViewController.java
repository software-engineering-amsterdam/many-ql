package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Form.ConditionalBlock;

public class ConditionalBlockIfElseViewController extends ConditionalBlockViewController 
{
	public ConditionalBlockIfElseViewController(ConditionalBlock conditionalBlock) 
	{
		super(conditionalBlock);
	}

	@Override
	public int evaluateViewHeight() 
	{	
		makeAllViewsInvisible();

		if (ifThenBlockViewController.viewShouldBeVisible())
		{
			ifThenBlockView().setVisible(true);

			int neededHeight = ifThenBlockViewController.evaluateViewHeight();

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
		else
		{
			elseThenBlockView().setVisible(true);

			int neededHeight = elseThenBlockViewController.evaluateViewHeight();

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
	}

	private void makeAllViewsInvisible()
	{
		ifThenBlockView().setVisible(false);

		elseThenBlockView().setVisible(false);
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		view.setPreferredSize(new Dimension(UIConstants.contentWidth(), neededHeight));
	}
}