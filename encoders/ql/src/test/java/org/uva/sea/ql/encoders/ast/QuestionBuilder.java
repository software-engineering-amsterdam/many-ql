package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.type.BooleanType;
import org.uva.sea.ql.encoders.ast.type.DataType;

public class QuestionBuilder {

	private TextLocation textLocation;
	private String name;
	private DataType dataType;
	private String questionLabel;
	private Expression computed;
	private Expression condition;

	public static QuestionBuilder aQuestion() {
		QuestionBuilder builder = new QuestionBuilder();
		builder.textLocation = new TextLocation(10, 10);
		builder.name = "why";
		builder.dataType = new BooleanType();
		builder.questionLabel = "Why?";
		builder.computed = null;
		builder.condition = null;
		return builder;
	}

	public Question build() {
		Question question = new Question(textLocation, name, dataType, questionLabel, condition, computed);
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

	public QuestionBuilder withQuestionLabel(String questionLabel) {
		this.questionLabel = questionLabel;
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
