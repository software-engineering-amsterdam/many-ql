package org.uva.sea.ql.encoders.model;

/**
 * Represents a question in the {@link Questionnaire}
 * 
 * @author Pim Tegelaar
 */
public class Question {

	private final String name;

	private final String condition;

	private final String type;

	private final String questionText;

	public Question(String name, String condition, String type,
			String questionText) {
		this.name = name;
		this.condition = condition;
		this.type = type;
		this.questionText = questionText;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getCondition() {
		return condition;
	}

}
