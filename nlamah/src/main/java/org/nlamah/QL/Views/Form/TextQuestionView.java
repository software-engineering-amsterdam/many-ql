package org.nlamah.QL.Views.Form;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.ViewControllers.Form.TextQuestionViewController;
import org.nlamah.QL.ViewControllers.Form.Abstract.FormElementViewController;
import org.nlamah.QL.Views.Abstract.FormElementView;

@SuppressWarnings("serial")
public class TextQuestionView extends FormElementView 
{
	private JLabel typeLabel;
	private JLabel questionLabel;
	private JTextField textField;
	
	public TextQuestionView(FormElementViewController viewController) 
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
	
	public void fillInTextField(String text)
	{
		textField.setText(text);
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

	@Override
	public void initializeComponents() 
	{
		typeLabel = new JLabel();
		questionLabel = new JLabel();
		textField = new JTextField();
		textField.setColumns(10);
		textField.addActionListener((TextQuestionViewController) viewController);
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
}
