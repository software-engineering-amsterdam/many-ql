package org.nlamah.QLS.View.Controllers;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;

import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.View.Stylesheet.PageView;

public class PageViewController extends StylesheetViewController 
{
	private String identifier;

	private List<SectionViewController> sectionViewControllers;

	private RootFormViewControllerStyled rootViewController;

	public PageViewController(Form form, String identifier, Page page, RootFormViewControllerStyled rootViewController) 
	{
		super(rootViewController, null);

		this.identifier = identifier;

		this.rootViewController = rootViewController;

		view = new PageView(page);

		createSectionViewControllers(form, page.sections());

		addSectionViewsToView();
	}

	public String identifier()
	{
		return identifier;
	}

	private void createSectionViewControllers(Form form, List<Section> sections)
	{
		sectionViewControllers = new ArrayList<SectionViewController>();

		for (Section section : sections)
		{
			sectionViewControllers.add(new SectionViewController(rootViewController, form, section, this));
		}
	}

	private void addSectionViewsToView()
	{
		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			view.add(sectionViewController.view);
		}

		view.add(Box.createRigidArea(new Dimension(0, 40)));
	}

	@Override
	public int neededViewHeight() 
	{
		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			sectionViewController.neededViewHeight();
		}

		return view.getPreferredSize().height;
	}
}