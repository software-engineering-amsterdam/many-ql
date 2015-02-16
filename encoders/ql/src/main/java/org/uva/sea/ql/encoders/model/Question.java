package org.uva.sea.ql.encoders.model;

/**
 * Represents a question in the {@link Questionnaire}
 * 
 * @author Pim Tegelaar
 */
public class Question {

	private String name;

	private String condition;

	private Object value;

	private String type;

	private String questionText;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
}
