package org.nlamah.QLS.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.View.Stylesheet.PageView;

public class PageViewController extends StylesheetViewController 
{
	private String identifier;
	
	private List<SectionViewController> sectionViewControllers;

	private RootFormViewControllerStyled parentViewController;
	
	public PageViewController(Form form, String identifier, Page page, RootFormViewControllerStyled parentViewController) 
	{
		super(parentViewController, null);
		
		this.identifier = identifier;

		this.parentViewController = parentViewController;
		
		view = new PageView(page);

		createSectionViewController(form, page.sections());
		
		addSectionViewsToView();
	}
	
	public String identifier()
	{
		return identifier;
	}

	private void createSectionViewController(Form form, List<Section> sections)
	{
		sectionViewControllers = new ArrayList<SectionViewController>();

		for (Section section : sections)
		{
			sectionViewControllers.add(new SectionViewController(parentViewController, form, section, this));
		}
	}
	
	private void addSectionViewsToView()
	{
		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			view.add(sectionViewController.view);
		}
	}

	@Override
	public int neededViewHeight() 
	{
		int preferredHeight = 0;

		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			preferredHeight += sectionViewController.neededViewHeight();
		}

		return preferredHeight;
	}
}
