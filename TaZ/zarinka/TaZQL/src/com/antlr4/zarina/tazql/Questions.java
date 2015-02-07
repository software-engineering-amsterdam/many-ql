package com.antlr4.zarina.tazql;

import java.util.ArrayList;
import java.util.List;

public class Questions {

	private List<QuestionLabels> questionLabels;
	MainFrame mframe = new MainFrame();
	QuestionLabels qLabel = new QuestionLabels();
	
	public Questions() {
		this.questionLabels = new ArrayList<>();
	//	this.labelList =  new ArrayList<JLabel>();
	}
	
	public void addLabel(QuestionLabels ql) {
		getQuestionLabels().add(ql);
	}
	
	public List<QuestionLabels> getQuestionLabels() {
		return questionLabels;
	}
	
	public void createLabel () {
		
		for (QuestionLabels ql : getQuestionLabels()) {			
			//System.out.println("createLabel method"+ql);
			//labelList.add(new JLabel(qLabel.getQuestionLabel()));
			//mframe.getLabel(qLabel.getQuestionLabel());
		}
				
	}
}
