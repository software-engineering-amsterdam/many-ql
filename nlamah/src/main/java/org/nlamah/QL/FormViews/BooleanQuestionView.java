package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.nlamah.QL.FormModel.BooleanQuestion;

@SuppressWarnings("serial")
public class BooleanQuestionView extends FormElementView implements ViewLoadingStrategy 
{

	private BooleanQuestion question;
	
	private JLabel typeLabel;
	private JLabel questionLabel;
	private JCheckBox checkBox;
	
	public BooleanQuestionView(BooleanQuestion question) 
	{
		super();
		
		this.question = question;
		
		layoutView();
		initializeComponents();
		addComponentsToView();
	}

	public void initializeComponents()
	{
		typeLabel = new JLabel(question.type());
		questionLabel = new JLabel(question.questionString());
		checkBox = new JCheckBox("Yes");
	}
	
	public void addComponentsToView()
	{	
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(typeLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(checkBox);
	}


	@Override
	public void layoutView() 
	{	
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBackground(Color.white);
		
		setPreferredSize(new Dimension(600, 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}
}
