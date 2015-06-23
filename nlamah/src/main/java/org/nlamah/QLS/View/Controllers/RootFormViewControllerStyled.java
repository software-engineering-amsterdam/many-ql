package org.nlamah.QLS.View.Controllers;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.Constants.UIConstants;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.View.Controllers.FormRootViewController;
import org.nlamah.QLS.Builders.PageFinder;
import org.nlamah.QLS.Model.Abstract.StylesheetBlock;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;

public class RootFormViewControllerStyled extends FormRootViewController
{		
	private Stylesheet stylesheet;

	private NavigationViewController navigationViewController;

	private List<PageViewController> pageViewControllers;

	private StylesheetBlock requestedBlock;

	public RootFormViewControllerStyled(Form form, Stylesheet stylesheet) 
	{
		super(form);

		this.stylesheet = stylesheet;

		navigationViewController = new NavigationViewController(stylesheet.pages(), this);

		setupNavigationView();

		restoreContentView();

		createPageViewControllers(stylesheet.pages());

		addPageViewsToView();

		show(stylesheet);
	}

	private String identifierForPage(Page page)
	{
		int position = stylesheet.pages().indexOf(page);

		return Integer.toString(position);
	}

	public Stylesheet stylesheet()
	{
		return stylesheet;
	}

	private PageViewController pageViewControllerForPage(Page page)
	{
		return pageViewControllers.get(stylesheet.pages().indexOf(page));
	}

	@Override
	public void run() 
	{
		showForm();
	}

	public void show(StylesheetBlock block)
	{
		requestedBlock = block;

		Page requestedPage = null;

		if (block instanceof Page)
		{
			requestedPage = (Page) block;
		}
		else if (block instanceof Section)
		{
			requestedPage = new PageFinder().pageForSection((Section) block);
		}
		else if (block instanceof Stylesheet)
		{
			requestedPage = ((Stylesheet) block).pages().get(0);
		}

		for (PageViewController pageViewController : pageViewControllers)
		{
			pageViewController.neededViewHeight();
		}

		PageViewController pageViewController = pageViewControllerForPage(requestedPage);

		contentView.setPreferredSize(new Dimension(contentView.getPreferredSize().width, pageViewController.neededViewHeight()));

		CardLayout cardLayout = (CardLayout) contentView.getLayout();

		cardLayout.show(contentView, pageViewController.identifier());
	}

	@Override
	public void modelStateChanged() 
	{
		super.modelStateChanged();

		if (requestedBlock != null)
		{
			show(requestedBlock);
		}
	}

	private void setupNavigationView()
	{
		navigationView.setPreferredSize(new Dimension(UIConstants.navigationViewWidth(), navigationViewController.neededViewHeight()));

		navigationView.add(navigationViewController.view);
	}

	private void restoreContentView()
	{
		contentView.removeAll();

		contentView.setLayout(new CardLayout());
	}

	private void createPageViewControllers(List<Page> pages)
	{
		pageViewControllers = new ArrayList<PageViewController>();

		for (Page page : pages)
		{
			pageViewControllers.add(new PageViewController((Form) modelElement, identifierForPage(page), page, this));
		}
	}

	private void addPageViewsToView()
	{
		for (PageViewController pageViewController : pageViewControllers)
		{
			contentView.add(pageViewController.view, pageViewController.identifier());
			contentView.setPreferredSize(new Dimension(UIConstants.contentWidth(), pageViewController.neededViewHeight()));
		}
	}
}