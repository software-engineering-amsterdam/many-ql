package org.uva.sea.ql.encoders.ast;

/**
 * Represents a question in the {@link Questionnaire}
 */
public class Question extends AstNode {

	private final String name;

	private final DataType type;

	private final String questionText;

	private String condition = null;

	private Expression expression = null;

	public Question(String name, DataType dataType, String questionText) {
		this.name = name;
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

	public Expression getExpression() {
		return expression;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
}
