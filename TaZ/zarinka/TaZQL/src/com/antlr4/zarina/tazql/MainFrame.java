package com.antlr4.zarina.tazql;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame {

	 JPanel contentPane;
	private JFrame mainFrame;
	private List<JLabel> labelList =new ArrayList<>();;
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		mainUi();
		//this.labelList = new ArrayList<>();
	}	
	
	public final void mainUi() {
		mainFrame = new JFrame("Questionnaire");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		mainFrame.setContentPane(contentPane);
		mainFrame.setVisible(true);	
		//setLabel();
	}
	
	public void setLabel() {
		Questions questions = new Questions();
		for (QuestionLabels ql : questions.getQuestionLabels()) {	
			System.out.println("setLabel: "+ql);
		}
	}
	
	public void getLabel(String text) {
		contentPane.add(new JLabel(text));
	}
}