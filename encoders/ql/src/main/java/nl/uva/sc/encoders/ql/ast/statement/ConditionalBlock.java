package nl.uva.sc.encoders.ql.ast.statement;

import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;

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
	public void collectQuestions(Collection<Question> questions) {
		questions.addAll(this.questions);
	}
}
