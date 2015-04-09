package org.nlamah.QL.FormViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import org.nlamah.QL.FormModel.ComputedQuestion;

@SuppressWarnings("serial")
public class ComputedQuestionView extends FormElementView implements ViewLoadingStrategy
{
	private ComputedQuestion question;
	
	private JLabel typeLabel;
	private JLabel questionLabel;
	
	
	public ComputedQuestionView(ComputedQuestion question) 
	{
		super();
		
		this.question = question;
		
		layoutView();
		initializeComponents();
		addComponentsToView();
	}

	@Override
	public void addComponentsToView() 
	{
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(typeLabel, BorderLayout.NORTH);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(questionLabel, BorderLayout.SOUTH);
	}

	@Override
	public void initializeComponents() 
	{
		typeLabel = new JLabel(question.type());
		questionLabel = new JLabel(question.questionString());
	}

	@Override
	public void layoutView() 
	{	
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBackground(Color.lightGray);
		
		setPreferredSize(new Dimension(600, 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}
}
