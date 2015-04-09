package org.nlamah.QL.FormViews;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.Question;

@SuppressWarnings("serial")
public class FormView extends JFrame {

	private JPanel questionsPanel;
	private JScrollPane scrollPane;
	
	public FormView(Form form)
	{
		setSize(300, 200);
		
		this.questionsPanel = new JPanel();
		questionsPanel.setSize(600, 400);
		questionsPanel.setLayout(new GridLayout(1000, 1, 10, 0));
		
		for (int i = 0; i < 1000; i++)
		{
			QuestionView question = null; //new QuestionView(new Question(Integer.toString(i + 1) + ".", "BOOL", Integer.toString(i+1) + "th question"));
			questionsPanel.add(question);
			System.out.println("test" + i);
		}
		
		this.scrollPane = new JScrollPane(questionsPanel);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		setTitle(form.getTitle());
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
//	private void addComponentsToPane(Container pane)
//	{
//		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
//		
//		JButton button1 = new JButton("button1", Component.CENTER);
//		JButton button2 = new JButton("button2");
//		JButton button3 = new JButton("button3");
//		
//		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pane.add(button1);
//        
//        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pane.add(button2);
//        
//        button3.setAlignmentX(Component.CENTER_ALIGNMENT);
//        pane.add(button3);
//        
//        
//        QuestionGUI question1 = new QuestionGUI(new Question("1.", "BOOL", "first question"));
//		QuestionGUI question2 = new QuestionGUI(new Question("2.", "BOOL", "second question"));
//		QuestionGUI question3 = new QuestionGUI(new Question("3.", "BOOL", "third question"));
//		QuestionGUI question4 = new QuestionGUI(new Question("4.", "BOOL", "fourth question"));
//		
////		question1.setAlignmentX(Component.CENTER_ALIGNMENT);
//		pane.add(question1);
//		pane.add(question2);
//		pane.add(question3);
//		pane.add(question4);
//        
//	}
	
//	private void createLayout(JComponent... arg) 
//	{
//        Container pane = getContentPane();
//        GroupLayout layout = new GroupLayout(pane);
//        pane.setLayout(layout);
//
//        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);
//
//        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
//
//        hGroup.addGroup(layout.createParallelGroup().
//                 addComponent(arg[0]).addComponent(arg[2]));
//        hGroup.addGroup(layout.createParallelGroup().
//                 addComponent(arg[1]));
//        layout.setHorizontalGroup(hGroup);
//
//        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
//        
//        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
//                 addComponent(arg[0]).addComponent(arg[1]));
//        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
//                 addComponent(arg[2]));
//        layout.setVerticalGroup(vGroup);
//    }
}
