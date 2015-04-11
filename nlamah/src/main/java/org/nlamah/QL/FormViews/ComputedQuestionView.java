package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import org.nlamah.QL.FormViewControllers.ComputedQuestionViewController;
import org.nlamah.QL.Helper.ArrayListHelper;

@SuppressWarnings("serial")
public class ComputedQuestionView extends FormElementView implements ViewLoadingStrategy
{	
	private JLabel typeLabel;
	private JLabel questionLabel;
	
	public ComputedQuestionView(ComputedQuestionViewController viewController) 
	{
		super(viewController);

		layoutView();
		initializeComponents();
		addComponentsToView();
	}

	public void fillInType(String type)
	{
		typeLabel.setText(type);
	}
	
	public void fillInQuestionString(String quesitonString)
	{
		questionLabel.setText(quesitonString);
	}
	
	@Override
	public void addComponentsToView() 
	{
		add(typeLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(questionLabel);
	}

	@Override
	public void initializeComponents() 
	{
		typeLabel = new JLabel();
		questionLabel = new JLabel();
	}

	@Override
	public void layoutView() 
	{	
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBackground(Color.lightGray);
		
		setPreferredSize(new Dimension(ArrayListHelper.contentWidth(), 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}
}
