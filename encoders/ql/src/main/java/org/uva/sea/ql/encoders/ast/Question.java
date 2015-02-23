package org.uva.sea.ql.encoders.ast;

/**
 * Represents a question in the {@link Questionnaire}
 */
public class Question extends AstNode {

	private final String name;

	private final String condition;

	private final DataType type;

	private final String questionText;

	public Question(String name, String condition, DataType dataType,
			String questionText) {
		this.name = name;
		this.condition = condition;
		this.type = dataType;
		this.questionText = questionText;
	}

	public String getName() {
		return name;
	}

	public DataType getDataType() {
		return type;
	}

	public String getQuestionText() {
		return questionText;
	}

	public String getCondition() {
		return condition;
	}

}
