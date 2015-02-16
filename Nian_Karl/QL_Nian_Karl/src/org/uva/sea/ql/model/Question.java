package org.uva.sea.ql.model;


public class Question {
	private final QuestionType questionType;
	private final String identifier;
	private final String questionLabel;


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

	public String getIdentifier() {
		return identifier;
	}

	public String getQuestionLabel() {
		return questionLabel;
	}

}
