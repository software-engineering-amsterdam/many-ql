package org.nlamah.QL.FormViewControllers;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ContentView;
import org.nlamah.QL.FormViews.NavigationView;
import org.nlamah.QL.Helper.Helper;

public class FormRootViewController extends FormElementViewController
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private JFrame frame;
	private NavigationView navigationView;
	private ContentView contentView;
	
	private int preferredViewHeight;
	
	public FormRootViewController(Form form)
	{
		super(form);
		
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
		
		frame.setTitle(((Form)modelElement()).getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void loadNavigationAndContentView()
	{
		navigationView = new NavigationView();
		
		contentView = new ContentView();
		
		ArrayList<FormElementViewController> childViewControllers = childViewControllers();
		
		for (int i = 0; i < childViewControllers.size(); i++)
		{
			contentView.add(Box.createVerticalGlue());
			
			contentView.add(childViewControllers.get(i).view());
		}
		
		adjustContentViewToProperHeight();
	}
	
	private void adjustContentViewToProperHeight()
	{
		contentView.setPreferredSize(new Dimension(Helper.contentWidth(), preferredViewHeight()));
	}
	
	private void addNavigationAndContentViews()
	{	
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, new JScrollPane(contentView));
        frame.setContentPane(splitPane);
	}


	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		System.out.println("test");
	}

	@Override
	public int preferredViewHeight() 
	{
		int preferredSize = 0;
		
		for (int i = 0; i < childViewControllers().size(); i++)
		{
			preferredSize += childViewControllers().get(i).preferredViewHeight();
		}
		
		this.preferredViewHeight = preferredSize;
		
		return preferredViewHeight;
	}

	@Override
	public void viewNeedsUpdate() 
	{
		adjustContentViewToProperHeight();
	}
}
