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

	private final String questionText;

	private Expression condition = null;

	private Expression computed = null;

	public Question(TextLocation textLocation, String name, DataType dataType, String questionText) {
		super(textLocation);
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

	public Expression getCondition() {
		return condition;
	}

	public Expression getComputed() {
		return computed;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	public void setComputed(Expression expression) {
		this.computed = expression;
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