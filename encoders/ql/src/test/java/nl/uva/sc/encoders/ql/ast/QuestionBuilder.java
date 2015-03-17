package nl.uva.sc.encoders.ql.ast;

import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;

public class QuestionBuilder {

	private TextLocation textLocation;
	private String name;
	private DataType dataType;
	private String questionLabel;
	private Expression computed;

	public static QuestionBuilder aQuestion() {
		QuestionBuilder builder = new QuestionBuilder();
		builder.textLocation = new TextLocation(10, 10);
		builder.name = "why";
		builder.dataType = new BooleanType();
		builder.questionLabel = "Why?";
		builder.computed = null;
		return builder;
	}

	public Question build() {
		Question question = new Question(textLocation, name, dataType, questionLabel, computed);
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

	public QuestionBuilder withComputed(Expression computed) {
		this.computed = computed;
		return this;
	}

}
