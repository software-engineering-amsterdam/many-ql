package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Form.ConditionalBlock;

public class ConditionalBlockIfViewController extends ConditionalBlockViewController 
{

	public ConditionalBlockIfViewController(ConditionalBlock conditionalBlock) 
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
			int neededHeight = 0;

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}

	}

	private void makeAllViewsInvisible()
	{
		ifThenBlockView.setVisible(false);
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		conditionalBlockView.setPreferredSize(new Dimension(Helper.contentWidth(), neededHeight));
	}
}
