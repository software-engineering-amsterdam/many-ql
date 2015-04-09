package org.nlamah.QL.FormViews;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.Question;

@SuppressWarnings("serial")
public class QuestionView extends JPanel implements ListCellRenderer<Question>
{	
	static final int questionHeight = 80;
	private JLabel typeLabel;
	private JLabel questionLabel;
	private JCheckBox checkBox;
	
	public QuestionView()
	{
		super();
		
		setPreferredSize(new Dimension(50, questionHeight));
		
		typeLabel = new JLabel("boolean");
		questionLabel = new JLabel("temp");
	
		checkBox = new JCheckBox("YES"); 
		checkBox.setSelected(false);
		checkBox.addItemListener(new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				System.out.println(e.getStateChange() == ItemEvent.SELECTED
	                    ? "SELECTED" : "DESELECTED");
				
			}
        });
		checkBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getID() == ActionEvent.ACTION_PERFORMED
                    ? "ACTION_PERFORMED" : e.getID());
            }
        });
		
		add(typeLabel);
		add(questionLabel);
		add(checkBox);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Question> list, Question value, int index, boolean isSelected, boolean cellHasFocus) 
	{
		Question question = value;
		
		questionLabel.setText(question.getLabel());
		
		if (value instanceof ComputedQuestion)
		{
//			System.out.println("is computed question");
		}
		else if (value instanceof Question)
		{
//			System.out.println("is question");
		}
		
		if (cellHasFocus)
		{
			setBackground(Color.white);
		}
		else
		{
			setBackground(Color.lightGray);
		}
		
		return this;
	}
}
