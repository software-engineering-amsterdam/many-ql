package nl.uva.sc.encoders.ql.ast;

import static nl.uva.sc.encoders.ql.ast.QuestionBuilder.aQuestion;
import static nl.uva.sc.encoders.ql.ast.TextLocationBuilder.aTextLocation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;

public class ConditionalBlockBuilder {

	private List<Question> questions = new ArrayList<>();
	private Expression condition;
	private TextLocation textLocation;

	public static ConditionalBlockBuilder aConditionalBlock() {
		ConditionalBlockBuilder conditionalBlockBuilder = new ConditionalBlockBuilder();
		conditionalBlockBuilder.condition = new BooleanLiteral(aTextLocation().build(), true);
		conditionalBlockBuilder.questions.add(aQuestion().build());
		conditionalBlockBuilder.textLocation = aTextLocation().build();
		return conditionalBlockBuilder;
	}

	public ConditionalBlock build() {
		return new ConditionalBlock(textLocation, condition, questions);
	}

	public ConditionalBlockBuilder withCondition(Expression condition) {
		this.condition = condition;
		return this;
	}

	public ConditionalBlockBuilder withQuestions(List<Question> questions) {
		this.questions = questions;
		return this;
	}

}
