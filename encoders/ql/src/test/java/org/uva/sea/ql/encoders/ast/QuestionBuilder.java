package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.DataType;

public class QuestionBuilder {

	private TextLocation textLocation;
	private String name;
	private DataType dataType;
	private String questionText;
	private Expression computed;
	private Expression condition;

	public static QuestionBuilder question() {
		QuestionBuilder builder = new QuestionBuilder();
		builder.textLocation = new TextLocation(10, 10);
		builder.name = "why";
		builder.dataType = new BooleanType();
		builder.questionText = "Why?";
		builder.computed = null;
		builder.condition = null;
		return builder;
	}

	public Question build() {
		Question question = new Question(textLocation, name, dataType, questionText);
		question.setCondition(condition);
		question.setComputed(computed);
		return question;
	}

	public QuestionBuilder withTextLocation(TextLocation textLocation) {
		this.textLocation = textLocation;
		return this;
	}

	public QuestionBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public QuestionBuilder withDataType(DataType dataType) {
		this.dataType = dataType;
		return this;
	}

	public QuestionBuilder withQuestionText(String questionText) {
		this.questionText = questionText;
		return this;
	}

	public QuestionBuilder withCondition(Expression condition) {
		this.condition = condition;
		return this;
	}

	public QuestionBuilder withComputed(Expression computed) {
		this.computed = computed;
		return this;
	}

}
