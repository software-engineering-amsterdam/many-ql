package org.nlamah.QL.View.Controllers;

import java.awt.Dimension;
import static javax.swing.ScrollPaneConstants.*;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.nlamah.QL.Builders.FormHeightAdjuster;
import org.nlamah.QL.Builders.QLViewControllersFactory;
import org.nlamah.QL.Builders.QLViewFactory;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.View.Controllers.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.View.Form.ContentView;
import org.nlamah.QL.View.Form.NavigationView;
import org.nlamah.QL.View.Form.Abstract.FormElementView;

public class FormRootViewController extends DeclaringFormElementViewController implements Runnable
{
	private final static int FRAME_WIDTH = 1000;
	private final static int FRAME_HEIGHT = 600;
	
	private JFrame frame;
	protected NavigationView navigationView;
	protected ContentView contentView;
	
	public FormRootViewController(Form form)
	{
		super(form);
		
		QLViewControllersFactory viewControllersFactory = new QLViewControllersFactory(this);
		
		setChildViewControllers(viewControllersFactory.createChildViewControllers(form));
		
		loadFrame();
		
		loadNavigationAndContentView();
		
		addNavigationAndContentViews();
	}
	
	@Override
	public void run() 
	{
		showForm();
	}
	
	protected void showForm()
	{
		frame.setVisible(true);
	}
	
	private void loadFrame()
	{
		frame = new JFrame();
		
		frame.setTitle(((Form) modelElement).title());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void loadNavigationAndContentView()
	{
		navigationView = new NavigationView();
		
		contentView = new ContentView();
		
		QLViewFactory viewsFactory = new QLViewFactory();
		
		List<FormElementView> childViews = viewsFactory.gatherChildViews(this);
		
		if (QBaseHelper.arrayExistsAndHasElements(childViews))
		{
			for (FormElementView childView : childViews)
			{	
				contentView.add(childView);
			}
		}
	}
	
	private void addNavigationAndContentViews()
	{	
		JScrollPane navigationViewScrollPane = new JScrollPane(navigationView);
		navigationViewScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane contentViewScrollPane = new JScrollPane(contentView);
		contentViewScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationViewScrollPane, contentViewScrollPane);
        
        contentView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededViewHeight()));
        
        frame.setContentPane(splitPane);
	}

	public void modelStateChanged() 
	{	
		contentView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededViewHeight()));
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
	
	@Override
	public int neededViewHeight() 
	{
		//TODO find better name
		FormHeightAdjuster heightAjuster = new FormHeightAdjuster();
		
		return heightAjuster.getPreferredHeight(childViewControllers());
	}
}
