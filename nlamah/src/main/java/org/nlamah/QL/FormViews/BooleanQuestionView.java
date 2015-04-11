package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import org.nlamah.QL.FormModel.BooleanQuestion;

@SuppressWarnings("serial")
public class BooleanQuestionView extends FormElementView implements ViewLoadingStrategy, ItemListener
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
		checkBox.addItemListener(this);
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
		setBackground(Color.white);
		
		setPreferredSize(new Dimension(600, 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		question.setChecked(checkBox.isSelected());
		
		formElementViewListener.modelStateChanged(question);
	}
}
