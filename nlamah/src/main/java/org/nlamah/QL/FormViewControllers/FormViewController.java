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

public class FormViewController extends FormElementViewController
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private Form form;
	
	private JFrame frame;
	private NavigationView navigationView;
	private ContentView contentView;
	
	private ArrayList<FormElementViewController> formElementViewControllers;
	private ArrayList<FormElementView> formElementViews;
	
	public FormViewController(Form form)
	{
		super();
		
		this.form = form;
		
		createFormElementViewControllers();
		extractFormElementViews();
		
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
		
        contentView = new ContentView(formElementViews);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, new JScrollPane(contentView));
        frame.setContentPane(splitPane);
	}
	
	private void createFormElementViewControllers()
	{
		int numberOfFormElements = form.formElements().size();
		
		ArrayList<FormElementViewController> formElementViewControllers= new ArrayList<FormElementViewController>(numberOfFormElements);
		
		for (int i = 0; i < numberOfFormElements; i++)
		{
			FormElement formElement = form.formElements().get(i);
			FormElementViewController formElementViewController = formElement.createViewController();
			formElementViewController.setParentViewController(this);
			formElementViewControllers.add(formElementViewController);
		}
		
		this.formElementViewControllers = formElementViewControllers;
	}
	
	private void extractFormElementViews()
	{
		int numberOfFormElements = form.formElements().size();
		
		ArrayList<FormElementView> formElementViews = new ArrayList<FormElementView>(numberOfFormElements);
		
		for (int i = 0; i < numberOfFormElements; i++)
		{
			FormElementViewController formElementViewController = formElementViewControllers.get(i);
			FormElementView formElementView = formElementViewController.view();
			formElementViews.add(formElementView);
		}
		
		this.formElementViews = formElementViews;
	}

	@Override
	public void modelStateChanged(FormElement formElement) 
	{
		System.out.println("test");
	}
}
