package org.nlamah.QL.FormViewControllers;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormViews.ContentView;
import org.nlamah.QL.FormViews.FormElementView;
import org.nlamah.QL.FormViews.NavigationView;
import org.nlamah.QL.Helper.ArrayListHelper;

public class FormRootViewController extends FormElementViewController
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private JFrame frame;
	private NavigationView navigationView;
	private ContentView contentView;
	
	public FormRootViewController(Form form)
	{
		super(form);
		
		loadFrame();
		addNavigationAndContentViews();
	}
	
	public void showForm()
	{
		frame.setVisible(true);
	}
	
	private void loadFrame()
	{
		frame = new JFrame();
		
		frame.setTitle(((Form)formElement()).getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addNavigationAndContentViews()
	{
		navigationView = new NavigationView();
		
		ArrayList<FormElementView> formElementViews = ArrayListHelper.createViewFromViewControllers(childViewControllers());
		
        contentView = new ContentView(formElementViews);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, new JScrollPane(contentView));
        frame.setContentPane(splitPane);
	}


	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		System.out.println("test");
	}
}
