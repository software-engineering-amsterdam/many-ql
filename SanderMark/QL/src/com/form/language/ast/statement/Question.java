package com.form.language.ast.statement;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Question implements Statement {
	private String id;
	private String questionLabel;
	private String type;
	
	private JPanel qPanel;
	private JPanel labelContainer;
	
	public Question(String questionLabel, String id, String type) {
		super();
		this.questionLabel = questionLabel;
		this.id = id;
		this.type = type;
	}
	
	public void createQuestion(){		
		qPanel = new JPanel();
		qPanel.setLayout(new BoxLayout(qPanel, BoxLayout.X_AXIS)); 
	}
	
	public void createQuestionLabel()
	{
		labelContainer = new JPanel();
        JLabel label = new JLabel();
        
        label.setText(questionLabel);
        labelContainer.add(label);
        qPanel.add(labelContainer);	
	}

	@Override
	public JComponent createGUIComponent() {
		createQuestion();
		createQuestionLabel();
		System.out.println(qPanel.getComponentCount());
		return qPanel;
	}	
}
