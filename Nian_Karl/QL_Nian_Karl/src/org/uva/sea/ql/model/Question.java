package org.uva.sea.ql.model;


public class Question {
	private QuestionType questionType;
	private String identifier;
	private String questionLabel;

	public Question() {
	}

	public Question(QuestionType questionType, String identifier,
			String questionLabel) {
		super();
		this.questionType = questionType;
		this.identifier = identifier;
		this.questionLabel = questionLabel;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}


	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}


	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}


	public String getQuestionLabel() {
		return questionLabel;
	}


	public void setQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
	}


}
