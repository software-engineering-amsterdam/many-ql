/*
 * @Zarina
 */
package com.antlr4.zarina.tazql;

import gui.MainFrame;

import java.util.ArrayList;
import java.util.List;

import ast.IMainVisitor;
import ast.Question;

public class Questions  {
	private String labelName;
	private String questionText;
	private String answerType;

	
	private List<Question> questionList = new ArrayList();
	MainFrame mframe = new MainFrame();
	QuestionLabels qLabel = new QuestionLabels();
	
	public Questions(String labelName, String questionText, String answerType) {
		this.labelName = labelName;
		this.questionText = questionText;
		this.answerType = answerType;
	//	this.questionLabels = new ArrayList<>();
		
		for(Question q : questionList) {
			this.questionList.add(q);
		}
	}
	
	
	public void addLabel(Question ql) {
		getQuestionList().add(ql);
	}
	
	public List<Question> getQuestionList() {
		return questionList;
	}
	
	/*
	@Override
	public <T> T accept(IMainVisitor<T> visitor) {
       return visitor.visit(this);
    }
    */
    
}
