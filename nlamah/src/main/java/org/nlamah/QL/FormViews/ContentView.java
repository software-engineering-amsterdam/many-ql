package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ContentView extends JPanel 
{	
	private ArrayList<FormElementView> formElementViews;
		
	public ContentView(ArrayList<FormElementView> formElementViews) 
	{
		super();
		
		this.formElementViews = formElementViews;
		
		layoutView();
		
		addComponentsToView();
	}
	
	private void layoutView()
	{
		setMaximumSize(new Dimension(500, 700));
		setMinimumSize(new Dimension(500,700));
		setPreferredSize(new Dimension(500,700));
		
		setBackground(Color.gray);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
		
	private void addComponentsToView()
	{
		double preferredHeight = 0;
		
		for (int i = 0; i < formElementViews.size(); i++)
		{
			FormElementView elementView = formElementViews.get(i);
			
			add(elementView);
			
			preferredHeight += elementView.getPreferredSize().getHeight();
		}
		
		setPreferredSize(new Dimension(500, (int)preferredHeight));
	}
}
