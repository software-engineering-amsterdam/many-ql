package org.nlamah.QL.Views.Form;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.ViewControllers.Form.NumberQuestionViewController;
import org.nlamah.QL.Views.Abstract.FormElementView;

@SuppressWarnings("serial")
public class NumberQuestionView extends FormElementView
{
	private JLabel typeLabel;
	private JLabel questionLabel;
	private JFormattedTextField textField;
	
	public NumberQuestionView(NumberQuestionViewController viewController) 
	{
		super(viewController);
	}
	
	public void fillInType(String type)
	{
		typeLabel.setText(type);
	}
	
	public void fillInQuestionString(String questionString)
	{
		questionLabel.setText(Helper.surroundStringWithHtmlTags(questionString));
	}
	
	public void fillInNumberField(String number)
	{
		textField.setText(number);
	}

	@Override
	public void initializeComponents()
	{
		typeLabel = new JLabel();
		questionLabel = new JLabel();
		textField = new JFormattedTextField(NumberFormat.getNumberInstance());
		textField.addActionListener((NumberQuestionViewController) viewController);
	}
	
	@Override
	public void addComponentsToView()
	{	
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(typeLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(questionLabel);
		add(Box.createRigidArea(new Dimension(10, 0)));
		add(textField);
		add(Box.createRigidArea(new Dimension(10, 0)));
	}
	
	@Override
	public void layoutView() 
	{
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setBackground(Color.white);
		
		textField.setPreferredSize(new Dimension(200, 24));
		textField.setMaximumSize(new Dimension(200, 24));
		textField.setMinimumSize(new Dimension(200, 24));
		
		setPreferredSize(new Dimension(Helper.contentWidth(), 100));
        setMaximumSize(getPreferredSize()); 
        setMinimumSize(getPreferredSize());
	}
}
