package org.uva.ql.model;

import org.uva.ql.type.QuestionType;

public class Question {

	private QuestionType type;
	private String question;
	private String questionName;
	 
	public Question() {
	}
	
	
	public Question(QuestionType type, String question, String questionName) {
		super();
		this.type = type;
		this.question = question;
		this.questionName = questionName;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	
	
}
