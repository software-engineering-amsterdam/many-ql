package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Form.ConditionalBlock;

public class ConditionalBlockIfElseViewController extends ConditionalBlockViewController 
{

	public ConditionalBlockIfElseViewController(ConditionalBlock conditionalBlock) 
	{
		super(conditionalBlock);
	}

	@Override
	public int neededViewHeight() 
	{	
		makeAllViewsInvisible();

		if (ifThenBlockViewController.viewShouldBeVisible())
		{
			ifThenBlockView.setVisible(true);

			int neededHeight = ifThenBlockViewController.neededViewHeight();

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
		else
		{
			elseThenBlockView.setVisible(true);

			int neededHeight = elseThenBlockViewController.neededViewHeight();

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
	}

	private void makeAllViewsInvisible()
	{
		ifThenBlockView.setVisible(false);

		elseThenBlockView.setVisible(false);
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		conditionalBlockView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
	}
}
