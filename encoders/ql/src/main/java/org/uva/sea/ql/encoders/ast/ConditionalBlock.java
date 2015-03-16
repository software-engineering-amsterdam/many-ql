package org.uva.sea.ql.encoders.ast;

import java.util.List;

import org.uva.sea.ql.encoders.ast.expression.Expression;

public class ConditionalBlock extends Statement {

	private final Expression condition;

	private final List<Question> questions;

	public ConditionalBlock(TextLocation textLocation, Expression condition, List<Question> questions) {
		super(textLocation);
		this.condition = condition;
		this.questions = questions;
	}

	public Expression getCondition() {
		return condition;
	}

	@Override
	public List<Question> getQuestions() {
		return questions;
	}
}
