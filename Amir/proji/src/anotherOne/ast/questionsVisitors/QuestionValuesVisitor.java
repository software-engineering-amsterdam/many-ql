package anotherOne.ast.questionsVisitors;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.IfQuestion;
import anotherOne.gui.input.labels.copy.Label;

public class QuestionValuesVisitor implements QuestionsVisitor<List<Object>>{

	public GridBagConstraints gbc = new GridBagConstraints();
	JLabel label = new JLabel("Java Swing Label Demo",JLabel.CENTER);
    JFrame frame = new JFrame();
	public JPanel panel = new JPanel(new GridBagLayout());

//	public QuestionValuesVisitor (JFrame frame){
//		this.frame = frame;
//	}
    
	public QuestionValuesVisitor(JFrame frame9) {
		// TODO Auto-generated constructor stub
		this.frame = frame9;
	}

	@Override
	public List<Object> visit(JFrame frame, BasicQuestion basQuest) {
		this.frame = frame; 
	    panel.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

	    gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6, 6, 0, 0);
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 1;
		gbc.gridwidth = 20; //GridBagConstraints.REMAINDER;
		frame.setSize(400,300);
		panel.add(new JLabel(basQuest.questionText),gbc); 
		gbc.gridy++;
		panel.add(new JCheckBox("Yes"),gbc); 

		panel.add(new JLabel ("PPP"),gbc); //question.
//		System.out.println (question.accept(new QuestionValuesVisitor()).get(1));
		gbc.gridy++;
		panel.add(new JCheckBox("LL"), gbc); //question.
		
		frame.add(panel);
		frame.setVisible(false);

		return (Arrays.asList(basQuest.questionId, 
				basQuest.questionText, 
				new JCheckBox("Yes")));
	}

	@Override
	public List<Object> visit(JFrame frame, ComputedQuestion compQuest) {
		System.out.println("check if the computed question fires");
		this.frame = frame;
		return (Arrays.asList(compQuest.questionId, 
				compQuest.questionText, new JTextField(20),
				compQuest.arithmeticExpr)); // .arithmeiticExpr));
				// expression should: bind sources,
				//    evaluate
				//
	}

	@Override
	public List<Object> visit(JFrame frame, IfQuestion ifQuest) {
		this.frame = frame;
		
		return (Arrays.asList(ifQuest.questionCondition, 
				ifQuest.isTrueList));  //, 
//				ifQuest.isFalseList));
	}

	

}
