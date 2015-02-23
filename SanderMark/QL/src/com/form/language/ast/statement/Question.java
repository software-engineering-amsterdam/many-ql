package com.form.language.ast.statement;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Question implements Statement {
	private String id;
	private String questionLabel;
	private String questionType;
	
	private JPanel qPanel;
	private JPanel labelContainer;
	
	public Question(String questionLabel, String id, String questionType) {
		super();
		this.questionLabel = questionLabel;
		this.id = id;
		this.questionType = questionType;
	}
	
	private void createQuestion(){		
		qPanel = new JPanel();
		qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS)); 
	}
	
	private void createQuestionLabel()
	{
		labelContainer = new JPanel();
        JLabel label = new JLabel();
        
        label.setText(questionLabel);
        labelContainer.add(label);
        qPanel.add(labelContainer);	
	}
	
	//Type checker implementation to be added
	private void createQuestionType()
	{
		if(questionType.equals("Boolean"))
		{
			JCheckBox checkbox = new JCheckBox();
			checkbox.setName(id);
			qPanel.add(checkbox);			
		}
		else if(questionType.equals("String"))
		{
			JTextField textfield = new JTextField();
			textfield.setName(id);
			qPanel.add(textfield);			
		}
		else
		{
			JTextField textfield = new JTextField();
			textfield.setName(id);
			qPanel.add(textfield);				
		}
	}

	@Override
	public JComponent createGUIComponent(JPanel panel) {
		createQuestion();
		createQuestionLabel();
		createQuestionType();
		return qPanel;
	}	
}
