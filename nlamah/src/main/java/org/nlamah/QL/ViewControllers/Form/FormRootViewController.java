package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.ViewControllers.Factory.QLViewControllersFactory;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Abstract.FormElementView;
import org.nlamah.QL.Views.Form.ContentView;
import org.nlamah.QL.Views.Form.NavigationView;
import org.nlamah.QL.Visitors.FormHeightAdjuster;
import org.nlamah.QL.Visitors.QLViewsFactory;

public class FormRootViewController extends DeclaringFormElementViewController
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private JFrame frame;
	private NavigationView navigationView;
	private ContentView contentView;
	
	public FormRootViewController(Form form)
	{
		super(form);
		
		QLViewControllersFactory viewControllersFactory = new QLViewControllersFactory(this);
		
		setChildViewControllers(viewControllersFactory.createChildViewControllers(form));
		
		loadFrame();
		
		loadNavigationAndContentView();
		
		addNavigationAndContentViews();
	}
	
	public void showForm()
	{
		frame.setVisible(true);
	}
	
	private void loadFrame()
	{
		frame = new JFrame();
		
		frame.setTitle(((Form) modelElement).getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void loadNavigationAndContentView()
	{
		navigationView = new NavigationView();
		
		contentView = new ContentView();
		
		QLViewsFactory viewsFactory = new QLViewsFactory();
		
		ArrayList<FormElementView> childViews = viewsFactory.gatherChildViews(this);
		
		for (FormElementView childView : childViews)
		{	
			contentView.add(childView);
		}
	}
	
	private void addNavigationAndContentViews()
	{	
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, new JScrollPane(contentView));
        
        contentView.setPreferredSize(new Dimension(Helper.contentWidth(), neededViewHeight()));
        
        frame.setContentPane(splitPane);
	}


	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		System.out.println("test");
	}

	@Override
	public void viewNeedsUpdate() 
	{
		
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
	
	@Override
	public int neededViewHeight() 
	{
		FormHeightAdjuster heightCalculator = new FormHeightAdjuster();
		
		return heightCalculator.getPreferredHeight(childViewControllers());
	}
}
