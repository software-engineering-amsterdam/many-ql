package org.nlamah.QL.FormViewControllers;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormViews.ContentView;
import org.nlamah.QL.FormViews.NavigationView;

public class FormViewController 
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private Form form;
	
	private JFrame frame;
	
	public FormViewController(Form form)
	{
		super();
		
		this.form = form;
		
		loadFrame();
		addNavigationAndContentViews();
	}
	
	public void showForm()
	{
		this.frame.setVisible(true);
	}
	
	private void loadFrame()
	{
		frame = new JFrame();
		
		frame.setTitle(form.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addNavigationAndContentViews()
	{
		NavigationView navigationView = new NavigationView();
        ContentView contentView = new ContentView();
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, contentView);
        frame.setContentPane(splitPane);
	}
}
