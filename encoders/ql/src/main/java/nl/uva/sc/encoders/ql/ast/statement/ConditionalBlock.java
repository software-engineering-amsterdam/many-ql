package nl.uva.sc.encoders.ql.ast.statement;

import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.visitor.StatementVisitor;

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

	public List<Question> getQuestions() {
		return questions;
	}

	@Override
	public void collectQuestions(Collection<Question> questions) {
		questions.addAll(this.questions);
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return condition.toString();
	}
}
