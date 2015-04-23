package org.nlamah.QL.Views.Form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.ViewLoadingStrategy;
import org.nlamah.QL.ViewControllers.Form.ComputedQuestionViewController;
import org.nlamah.QL.Views.Abstract.FormElementView;

@SuppressWarnings("serial")
public class ComputedQuestionView extends FormElementView implements ViewLoadingStrategy
{	
	private JLabel typeLabel;
	private JLabel questionLabel;
	private JLabel computedValueLabel;
	
	public ComputedQuestionView(ComputedQuestionViewController viewController) 
	{
		super(viewController);
	}

	public void fillInType(String type)
	{
		typeLabel.setText(type);
	}
	
	public void fillInQuestionString(String quesitonString)
	{
		questionLabel.setText(quesitonString);
	}
	
	public void fillInComputedValueLabel(String computedValueString)
	{
		computedValueLabel.setText(computedValueString);
	}
	
	@Override
	public void addComponentsToView() 
	{
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(typeLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(computedValueLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
	}

	@Override
	public void initializeComponents() 
	{
		typeLabel = new JLabel();
		questionLabel = new JLabel();
		computedValueLabel = new JLabel();
	}

	@Override
	public void layoutView() 
	{	
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBackground(Color.white);
		
		setPreferredSize(new Dimension(QLHelper.contentWidth(), 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}
}
