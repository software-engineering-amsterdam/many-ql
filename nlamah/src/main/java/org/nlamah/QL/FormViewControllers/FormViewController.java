package org.nlamah.QL.FormViewControllers;

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
	private NavigationView navigationView;
	private ContentView contentView;
	
	public FormViewController(Form form)
	{
		super();
		
		this.form = form;
		
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
		
		frame.setTitle(form.getTitle());
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addNavigationAndContentViews()
	{
		navigationView = new NavigationView();
        contentView = new ContentView(form.getFormElements());
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, new JScrollPane(contentView));
        frame.setContentPane(splitPane);
	}
}
