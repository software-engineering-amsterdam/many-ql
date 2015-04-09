package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.BooleanQuestion;
import org.nlamah.QL.FormModel.Question;

@SuppressWarnings("serial")
public class ContentView extends JPanel 
{	
	private ArrayList<FormElement> formElements;
	
	public ContentView(ArrayList<FormElement> formElements) 
	{
		super();
		
		this.formElements = formElements;
		
		layoutView();
		
		intitializeDummyFormElements();
		
		addComponentsToView();
	}
	
	private void layoutView()
	{
		setMinimumSize(new Dimension(350,350));
		setPreferredSize(new Dimension(350,700));
		
		setBackground(Color.gray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}
	
	private void intitializeDummyFormElements()
	{
		formElements = new ArrayList<FormElement>(1000);
		
		Question question;
		
		for (int i = 0; i < 1000; i++)
		{
			if (i%2==0)
			{
				question = new BooleanQuestion(Integer.toString(i + 1) + ".", Integer.toString(i+1) + "th question", "BOOL");
				
			}
			else
			{
				question = new ComputedQuestion(Integer.toString(i+1) + ".", Integer.toString(i+1) + "th question", "Computed", Integer.toString(i * i));
	
			}
			
			formElements.add(question);
		}
	}
	
	private void addComponentsToView()
	{
		double preferredHeight = 0;
		
		for (int i = 0; i < formElements.size(); i++)
		{
			FormElementView elementView = formElements.get(i).createView();
			add(elementView);
			preferredHeight += elementView.getPreferredSize().getHeight();
		}
		
		setPreferredSize(new Dimension(500, (int)preferredHeight));
		validate();
	}
}
