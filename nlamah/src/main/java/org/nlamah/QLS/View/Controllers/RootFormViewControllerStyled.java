package org.nlamah.QLS.View.Controllers;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Helper.QLHelper;
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
		
		PageViewController pageViewController = pageViewControllerForPage(requestedPage);
		
		CardLayout cardLayout = (CardLayout) contentView.getLayout();
		
		cardLayout.show(contentView, pageViewController.identifier());
		
		modelStateChanged();
	}
	
	@Override
	public void modelStateChanged() 
	{
		contentView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededViewHeight()));
		
		for (PageViewController pageViewController : pageViewControllers)
		{
			contentView.setPreferredSize(new Dimension(QLHelper.contentWidth(), pageViewController.neededViewHeight()));
		}
		
		for (PageViewController pageViewController : pageViewControllers)
		{
			contentView.setPreferredSize(new Dimension(QLHelper.contentWidth(), pageViewController.neededViewHeight()));
		}
	}
	
	private void setupNavigationView()
	{
		navigationView.setPreferredSize(new Dimension(QLHelper.navigationViewWidth(), navigationViewController.neededViewHeight()));
		
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
			contentView.setPreferredSize(new Dimension(QLHelper.contentWidth(), pageViewController.neededViewHeight()));
		}
	}
}
