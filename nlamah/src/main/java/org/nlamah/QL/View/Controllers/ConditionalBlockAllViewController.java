package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.View.Form.ElseIfThenBlockView;

public class ConditionalBlockAllViewController extends ConditionalBlockViewController 
{
	public ConditionalBlockAllViewController(ConditionalBlock conditionalBlock) 
	{
		super(conditionalBlock);
	}

	@Override
	public int evaluateViewHeight() 
	{	
		makeAllViewsInvisible();

		if (ifThenBlockViewController.viewShouldBeVisible())
		{
			ifThenBlockViewController.view().setVisible(true);

			int neededHeight = ifThenBlockViewController.evaluateViewHeight();

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

					ElseIfThenBlockView elseIfThenBlockView = elseIfThenBlockViews().get(index);

					elseIfThenBlockView.setVisible(true);

					int neededHeight = elseIfThenBlockViewController.evaluateViewHeight();

					adjustViewHeightToNeededHeight(neededHeight);

					return neededHeight;
				}
			}


			elseThenBlockView().setVisible(true);

			int neededHeight = elseThenBlockViewController.evaluateViewHeight();

			adjustViewHeightToNeededHeight(neededHeight);

			return neededHeight;
		}
	}

	private void makeAllViewsInvisible()
	{
		ifThenBlockView().setVisible(false);

		for (ElseIfThenBlockView elseIfThenBlockView : elseIfThenBlockViews())
		{
			elseIfThenBlockView.setVisible(false);
		}

		elseThenBlockView().setVisible(false);
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		view.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
	}
}
