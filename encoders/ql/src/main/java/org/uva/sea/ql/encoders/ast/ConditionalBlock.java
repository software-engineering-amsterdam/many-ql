package org.uva.sea.ql.encoders.ast;

import java.util.List;

import org.uva.sea.ql.encoders.ast.expression.Expression;
import org.uva.sea.ql.encoders.visitor.AstVisitor;

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

	@Override
	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
