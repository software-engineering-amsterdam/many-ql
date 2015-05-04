package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.View.Form.ElseIfThenBlockView;

public class ConditionalBlockIfElseIfViewController extends ConditionalBlockViewController 
{

	public ConditionalBlockIfElseIfViewController(ConditionalBlock conditionalBlock) 
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
			for (ElseIfThenBlockViewController elseIfThenBlockViewController : elseIfThenBlockViewControllers)
			{
				if (elseIfThenBlockViewController.shouldBeVisisble())
				{
					int index = elseIfThenBlockViewControllers.indexOf(elseIfThenBlockViewController);

					ElseIfThenBlockView elseIfThenBlockView = elseIfThenBlockViews.get(index);

					elseIfThenBlockView.setVisible(true);

					int neededHeight = elseIfThenBlockViewController.neededViewHeight();

					adjustViewHeightToNeededHeight(neededHeight);

					return neededHeight;
				}
			}

			int neededHeight = 0;

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
	}

	private void makeAllViewsInvisible()
	{
		ifThenBlockView.setVisible(false);

		for (ElseIfThenBlockView elseIfThenBlockView : elseIfThenBlockViews)
		{
			elseIfThenBlockView.setVisible(false);
		}
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		conditionalBlockView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
	}
}
