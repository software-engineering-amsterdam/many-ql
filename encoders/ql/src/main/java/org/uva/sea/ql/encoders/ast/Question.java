package org.uva.sea.ql.encoders.ast;

import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.ast.type.DataType;
import org.uva.sea.ql.encoders.visitor.AstVisitor;

/**
 * Represents a question in the {@link Questionnaire}
 */
public class Question extends AstNode {

	private final String name;

	private final DataType type;

	private final String questionLabel;

	private final Expression condition;

	private final Expression computed;

	public Question(TextLocation textLocation, String name, DataType type, String questionLabel, Expression condition,
			Expression computed) {
		super(textLocation);
		this.name = name;
		this.type = type;
		this.questionLabel = questionLabel;
		this.condition = condition;
		this.computed = computed;
	}

	public String getName() {
		return name;
	}

	public DataType getDataType() {
		return type;
	}

	public String getQuestionLabel() {
		return questionLabel;
	}

	public Expression getCondition() {
		return condition;
	}

	public Expression getComputed() {
		return computed;
	}

	@Override
	public String toString() {
		return name.toString();
	}

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
