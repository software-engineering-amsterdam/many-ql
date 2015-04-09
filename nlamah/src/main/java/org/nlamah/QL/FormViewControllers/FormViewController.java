package org.nlamah.QL.FormViewControllers;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.nlamah.QL.FormModel.BooleanQuestion;
import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.FormViews.ContentView;
import org.nlamah.QL.FormViews.FormElementView;
import org.nlamah.QL.FormViews.NavigationView;

public class FormViewController implements FormElementViewListener
{
	private final static int FRAME_WIDTH = 900;
	private final static int FRAME_HEIGHT = 600;
	
	private Form form;
	
	private JFrame frame;
	private NavigationView navigationView;
	private ContentView contentView;
	
	private ArrayList<FormElementView> formElementViews;
	
	private boolean toggle = true;
	
	public FormViewController(Form form)
	{
		super();
		
		this.form = form;
		
		form.setFormElements(createDummyFormElements());
		
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
		createFormElementViews();
        contentView = new ContentView(formElementViews);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, navigationView, new JScrollPane(contentView));
        frame.setContentPane(splitPane);
	}
	
	private ArrayList<FormElement> createDummyFormElements()
	{
		ArrayList<FormElement> formElements = new ArrayList<FormElement>(80);
		
		Question question;
		
		for (int i = 0; i < 80; i++)
		{
			if (i % 2 == 0)
			{
				question = new BooleanQuestion(Integer.toString(i + 1) + ".", Integer.toString(i+1) + "th question", "BOOL");	
			}
			else
			{
				question = new ComputedQuestion(Integer.toString(i+1) + ".", Integer.toString(i+1) + "th question", "Computed", Integer.toString(i * i));
			}
			
			formElements.add(question);
		}
		
		return formElements;
	}
	
	private void createFormElementViews()
	{
		int numberOfFormElements = form.formElements().size();
		
		ArrayList<FormElementView> formElementViews = new ArrayList<FormElementView>(numberOfFormElements);
		
		for (int i = 0; i < numberOfFormElements; i++)
		{
			FormElementView formElementView = form.formElements().get(i).createView();
			formElementView.setFormElementViewListener(this);
			formElementViews.add(formElementView);
		}
		
		this.formElementViews = formElementViews;
	}

	@Override
	public void valueChanged(FormElementView formElementView) 
	{
		toggle = !toggle;
		formElementViews.get(1).setVisible(toggle);
	}
}
