package org.nlamah.QL.FormViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.Question;

@SuppressWarnings("serial")
public class ContentView extends JPanel 
{
	private JPanel questionsView;
	private JScrollPane scrollPane;
	
	private JList<Question> questionsList;
	
	public ContentView() 
	{
		super();
		
		setMinimumSize(new Dimension(350,350));
		setPreferredSize(new Dimension(350,700));
		
		setBackground(Color.gray);
		
		setLayout(new GridLayout(0, 1));
		
		Question[] questions = new Question[1000];
		
		for (int i = 0; i < 1000; i++)
		{
			if (i%2==0)
			{
				Question question = new Question(Integer.toString(i + 1) + ".", "BOOL", Integer.toString(i+1) + "th question");
				questions[i] = question;
			}
			else
			{
				ComputedQuestion computedQuestion = new ComputedQuestion(Integer.toString(i+1) + ".", "Computed", Integer.toString(i+1) + "th question", Integer.toString(i * i));
				questions[i] = computedQuestion;
			}
		}
		
		questionsList = new JList<Question>(questions);
		questionsList.setCellRenderer(new QuestionView());
		questionsList.setVisibleRowCount(4);
	    JScrollPane pane = new JScrollPane(questionsList);
	    add(pane);
	}
}
