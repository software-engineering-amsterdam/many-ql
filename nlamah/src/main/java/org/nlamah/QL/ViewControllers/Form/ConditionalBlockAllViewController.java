package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Form.ConditionalBlock;
import org.nlamah.QL.Views.Form.ElseIfThenBlockView;

public class ConditionalBlockAllViewController extends ConditionalBlockViewController 
{
	public ConditionalBlockAllViewController(ConditionalBlock conditionalBlock) 
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

			elseThenBlockView.setVisible(true);

			int neededHeight = elseThenBlockViewController.neededViewHeight();

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
		
		elseThenBlockView.setVisible(false);
	}

	private void adjustViewHeightToNeededHeight(int neededHeight)
	{
		conditionalBlockView.setPreferredSize(new Dimension(Helper.contentWidth(), neededHeight));
	}
}
