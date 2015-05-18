package org.nlamah.QLS.View.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.nlamah.QLS.Builders.SectionsCollector;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.View.Stylesheet.NavigationButton;
import org.nlamah.QLS.View.Stylesheet.NavigationSubviewPage;

public class NavigationPageViewController extends StylesheetViewController implements ActionListener 
{
	private List<Section> sections;

	private NavigationViewController navigationViewController;

	public NavigationPageViewController(Page page, NavigationViewController navigationViewController) 
	{		
		this.navigationViewController = navigationViewController;

		sections = new SectionsCollector().sectionsForPage(page);

		view = new NavigationSubviewPage(page, sections, this);
	}

	@Override
	public int neededViewHeight() 
	{
		return view.getPreferredSize().height;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		navigationViewController.navigationChangeRequested(((NavigationButton) e.getSource()).value());	
	}	
}