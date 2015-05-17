package org.nlamah.QLS.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.View.Form.NavigationView;
import org.nlamah.QLS.Model.Abstract.StylesheetBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;

public class NavigationViewController extends StylesheetViewController
{	
	private List<NavigationPageViewController> navigationPageViewControllers;

	private RootFormViewControllerStyled rootFormViewController;

	public NavigationViewController(List<Page> pages, RootFormViewControllerStyled rootFormViewController) 
	{
		super();

		this.rootFormViewController = rootFormViewController;

		navigationPageViewControllers = new ArrayList<NavigationPageViewController>();

		for (Page page : pages)
		{
			navigationPageViewControllers.add(new NavigationPageViewController(page, this));
		}

		view = new NavigationView();

		for (NavigationPageViewController navigationPageViewController : navigationPageViewControllers)
		{
			view.add(navigationPageViewController.view);
		}
	}

	@Override
	public int neededViewHeight() 
	{
		int neededHeight = 0;

		for (NavigationPageViewController navigationPageViewController : navigationPageViewControllers)
		{
			neededHeight += navigationPageViewController.neededViewHeight();
		}

		return neededHeight;
	}

	public void navigationChangeRequested(StylesheetBlock object) 
	{
		rootFormViewController.show(object);
	}	
}
