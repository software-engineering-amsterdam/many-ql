package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Form.ConditionalBlock;

public class ConditionalBlockIfViewController extends ConditionalBlockViewController 
{
	public ConditionalBlockIfViewController(ConditionalBlock conditionalBlock) 
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
			int neededHeight = 0;

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
	}

	private void makeAllViewsInvisible()
	{
		ifThenBlockView().setVisible(false);
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		view.setPreferredSize(new Dimension(UIConstants.contentWidth(), neededHeight));
	}
}